function changeTextSize(){
    document.getElementById("text").style.fontSize = "2em";
}

function handleAlert(){
    alert("This is an example alert!")
    if(document.getElementById("fancy").checked){
        document.getElementById("text").style.fontWeight = "bold";
        document.getElementById("text").style.color = "blue";
        document.getElementById("text").style.textDecoration = "underline";  
    }
    else if(document.getElementById("boring").checked){
        document.getElementById("text").style.fontWeight = "normal"; 
        document.getElementById("text").style.color = "black"; 
        document.getElementById("text").style.textDecoration = "none"; 
    }
}

function makeCaps(){
    var text = document.getElementById("text").value;
    text = text.toUpperCase();
    var split = text.split(".");
    split = split.join("-Moo.")
    document.getElementById("text").value = split;
}


