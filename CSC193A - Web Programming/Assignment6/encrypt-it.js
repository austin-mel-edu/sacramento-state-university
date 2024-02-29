/*
 * Starter file 
 */
(function() {
  "use strict";

  window.addEventListener("load", init);

  function cypherInput(){
    //console.log("Button clicked!")
    let input = document.getElementById("input-text").value.toLowerCase();
    let result = "";
    for (let i = 0; i < input.length; i++){
      if (input[i] < "a" || input[i] > "z"){
        result += input[i];
      }
      else if (input[i] == "z"){
        result += "a";
      }
      else{
        let letter = input.charCodeAt(i);
        let shiftedLetter = String.fromCharCode(letter + 1);
        result += shiftedLetter;
      }
    }
    console.log(result)
    document.getElementById("result").innerHTML = result
  }

  function handleReset(){
    document.getElementById("input-text").value = "";
  }

  function init() {
    document.getElementById("encrypt-it").addEventListener("click", cypherInput);
    document.getElementById("reset").addEventListener("click", handleReset);
  }
})();
