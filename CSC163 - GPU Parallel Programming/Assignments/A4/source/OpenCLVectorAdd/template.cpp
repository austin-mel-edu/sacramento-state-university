#include <wb.h>
#include <CL/opencl.h>
#include <math.h>
#include <stdio.h>
#include <stdlib.h>

//@@ Write the OpenCL kernel
const char *kernelSource =
"__kernel void vecAdd(__global const float *a, __global const float *b, __global float *c, int n) {\n"
"    int id = get_global_id(0);\n"
"    if (id < n) {\n"
"        c[id] = a[id] + b[id];\n"
"    }\n"
"}\n";

int main(int argc, char* argv[]) {
    wbArg_t args;
    int inputLength;
    int inputLengthBytes;
    float* hostInput1;
    float* hostInput2;
    float* hostOutput;
    cl_mem deviceInput1;
    cl_mem deviceInput2;
    cl_mem deviceOutput;
    deviceInput1 = NULL;
    deviceInput2 = NULL;
    deviceOutput = NULL;

    cl_platform_id cpPlatform;
    cl_device_id device_id;
    cl_context context;
    cl_command_queue queue;
    cl_program program;
    cl_kernel kernel;

    context = NULL;
    queue = NULL;
    program = NULL;
    kernel = NULL;

    args = wbArg_read(argc, argv);

    wbTime_start(Generic, "Importing data and creating memory on host");
    hostInput1 =
        (float*)wbImport(wbArg_getInputFile(args, 0), &inputLength);
    hostInput2 =
        (float*)wbImport(wbArg_getInputFile(args, 1), &inputLength);
    inputLengthBytes = inputLength * sizeof(float);
    hostOutput = (float*)malloc(inputLengthBytes);
    wbTime_stop(Generic, "Importing data and creating memory on host");

    wbLog(TRACE, "The input length is ", inputLength);
    wbLog(TRACE, "The input size is ", inputLengthBytes, " bytes");

    //@@ Initialize the workgroup dimensions
    size_t localSize = 16;
    size_t globalSize = 16;

    //@@ Bind to platform
    cl_int status;
    status = clGetPlatformIDs(1, &cpPlatform, NULL);

    //@@ Get ID for the device
    status = clGetDeviceIDs(cpPlatform, CL_DEVICE_TYPE_GPU, 1, &device_id, NULL);

    //@@ Create a context
    context = clCreateContext(0, 1, &device_id, NULL, NULL, &status);

    //@@ Create a command queue
    queue = clCreateCommandQueue(context, device_id, 0, &status);

    //@@ Create the compute program from the source buffer
    program = clCreateProgramWithSource(context, 1, &kernelSource, NULL, &status);

    //@@ Build the program executable
    status = clBuildProgram(program, 1, &device_id, NULL, NULL, NULL);

    //@@ Create the compute kernel in the program we wish to run
    kernel = clCreateKernel(program, "vecAdd", &status);

    //@@ Create the input and output arrays in device memory for our calculation
    deviceInput1 = clCreateBuffer(context, CL_MEM_READ_ONLY,
        inputLengthBytes, NULL, &status);

    deviceInput2 = clCreateBuffer(context, CL_MEM_READ_ONLY,
        inputLengthBytes, NULL, &status);

    deviceOutput = clCreateBuffer(context, CL_MEM_WRITE_ONLY,
        inputLengthBytes, NULL, &status);

    //@@ Write our data set into the input array in device memory
    clEnqueueWriteBuffer(queue, deviceInput1, CL_TRUE, 0,
        inputLengthBytes, hostInput1, 0, NULL, NULL);

    clEnqueueWriteBuffer(queue, deviceInput2, CL_TRUE, 0,
        inputLengthBytes, hostInput2, 0, NULL, NULL);

    //@@ Set the arguments to our compute kernel
    clSetKernelArg(kernel, 0, sizeof(cl_mem), &deviceInput1);
    clSetKernelArg(kernel, 1, sizeof(cl_mem), &deviceInput2);
    clSetKernelArg(kernel, 2, sizeof(cl_mem), &deviceOutput);
    clSetKernelArg(kernel, 3, sizeof(int), &inputLength);

    //@@ Execute the kernel over the entire range of the data set
    clEnqueueNDRangeKernel(queue, kernel, 1, NULL,
        &globalSize, &localSize,
        0, NULL, NULL);

    //@@ Wait for the command queue to get serviced before reading back results
    clFinish(queue);

    //@@ Read the results from the device
    clEnqueueReadBuffer(queue, deviceOutput, CL_TRUE, 0,
        inputLengthBytes, hostOutput,
        0, NULL, NULL);

    wbSolution(args, hostOutput, inputLength);

    // release OpenCL resources
    clReleaseMemObject(deviceInput1);
    clReleaseMemObject(deviceInput2);
    clReleaseMemObject(deviceOutput);
    clReleaseProgram(program);
    clReleaseKernel(kernel);
    clReleaseCommandQueue(queue);
    clReleaseContext(context);

    // release host memory
    free(hostInput1);
    free(hostInput2);
    free(hostOutput);

    return 0;
}