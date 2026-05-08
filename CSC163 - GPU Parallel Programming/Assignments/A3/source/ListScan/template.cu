#include <cuda_runtime.h>
#include <device_launch_parameters.h>
#include <wb.h>

#define BLOCK_SIZE 512

#define wbCheck(stmt)                                                     \
  do {                                                                    \
    cudaError_t err = stmt;                                               \
    if (err != cudaSuccess) {                                             \
      wbLog(ERROR, "Failed to run stmt ", #stmt);                         \
      wbLog(ERROR, "Got CUDA error ...  ", cudaGetErrorString(err));      \
      return -1;                                                          \
    }                                                                     \
  } while (0)

__global__ void scan(float* input, float* output, float* aux, int len) {
    //@@ Modify the body of this kernel

    __shared__ float temp[2 * BLOCK_SIZE];

    int tid = threadIdx.x;
    int start = 2 * blockIdx.x * blockDim.x;

    int i = start + tid;
    int j = start + tid + blockDim.x;

    temp[tid] = (i < len) ? input[i] : 0.0f;
    temp[tid + blockDim.x] = (j < len) ? input[j] : 0.0f;

    for (int stride = 1; stride <= blockDim.x; stride *= 2) {
        __syncthreads();
        int idx = (tid + 1) * stride * 2 - 1;
        if (idx < 2 * blockDim.x)
            temp[idx] += temp[idx - stride];
    }

    if (tid == 0) {
        if (aux != NULL) {
            aux[blockIdx.x] = temp[2 * blockDim.x - 1];
        }
        temp[2 * blockDim.x - 1] = 0;
    }

    for (int stride = blockDim.x; stride > 0; stride /= 2) {
        __syncthreads();
        int idx = (tid + 1) * stride * 2 - 1;
        if (idx < 2 * blockDim.x) {
            float t = temp[idx - stride];
            temp[idx - stride] = temp[idx];
            temp[idx] += t;
        }
    }
    __syncthreads();

    if (i < len)
        output[i] = temp[tid] + input[i];
    if (j < len)
        output[j] = temp[tid + blockDim.x] + input[j];
}

__global__ void addScannedBlockSums(float* output, float* aux, int len) {
    //@@ Modify the body
    int gid = blockIdx.x * blockDim.x * 2 + threadIdx.x;

    if (blockIdx.x == 0) return;

    float val = aux[blockIdx.x];

    if (gid < len)
        output[gid] += val;

    if (gid + blockDim.x < len)
        output[gid + blockDim.x] += val;
}

int main(int argc, char** argv) {
    wbArg_t args;
    float* hostInput;
    float* hostOutput;
    float* deviceInput;
    float* deviceOutput;
    float* deviceAuxArray, * deviceAuxScannedArray;
    int numElements;

    args = wbArg_read(argc, argv);

    wbTime_start(Generic, "Importing data and creating memory on host");
    hostInput = (float*)wbImport(wbArg_getInputFile(args, 0), &numElements);
    hostOutput = (float*)malloc(numElements * sizeof(float));
    wbTime_stop(Generic, "Importing data and creating memory on host");

    wbLog(TRACE, "The number of input elements in the input is ",
        numElements);

    wbTime_start(GPU, "Allocating device memory.");
    //@@ Allocate device memory
    cudaMalloc((void**)&deviceInput, numElements * sizeof(float));
    cudaMalloc((void**)&deviceOutput, numElements * sizeof(float));
    cudaMalloc((void**)&deviceAuxArray, BLOCK_SIZE * 2 * sizeof(float));
    cudaMalloc((void**)&deviceAuxScannedArray, BLOCK_SIZE * 2 * sizeof(float));
    wbTime_stop(GPU, "Allocating device memory.");

    wbTime_start(GPU, "Clearing output device memory.");
    //@@ zero out
    wbCheck(cudaMemset(deviceOutput, 0, numElements * sizeof(float)));
    wbTime_stop(GPU, "Clearing output device memory.");

    wbTime_start(GPU, "Copying input host memory to device.");
    //@@ Copy input
    cudaMemcpy(deviceInput, hostInput,
        numElements * sizeof(float),
        cudaMemcpyHostToDevice);
    wbTime_stop(GPU, "Copying input host memory to device.");

    //@@ Initialize grid/block
    dim3 blockDim(BLOCK_SIZE);
    dim3 gridDim((numElements + BLOCK_SIZE * 2 - 1) / (BLOCK_SIZE * 2));

    wbTime_start(Compute, "Performing CUDA computation");
    //@@ Launch kernels

    scan <<< gridDim, blockDim >>> (deviceInput, deviceOutput,
        deviceAuxArray, numElements);

    scan <<< 1, blockDim >>> (deviceAuxArray,
        deviceAuxScannedArray,
        NULL,
        gridDim.x);

    addScannedBlockSums <<< gridDim, blockDim >>> (
        deviceOutput,
        deviceAuxScannedArray,
        numElements);

    cudaDeviceSynchronize();
    wbTime_stop(Compute, "Performing CUDA computation");

    wbTime_start(Copy, "Copying output device memory to host");
    //@@ Copy results
    cudaMemcpy(hostOutput, deviceOutput,
        numElements * sizeof(float),
        cudaMemcpyDeviceToHost);
    wbTime_stop(Copy, "Copying output device memory to host");

    wbTime_start(GPU, "Freeing device memory");
    //@@ Free memory
    cudaFree(deviceInput);
    cudaFree(deviceOutput);
    cudaFree(deviceAuxArray);
    cudaFree(deviceAuxScannedArray);
    wbTime_stop(GPU, "Freeing device memory");

    wbSolution(args, hostOutput, numElements);

    free(hostInput);
    free(hostOutput);

    return 0;
}