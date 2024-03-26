'use strict';
const { json } = require('body-parser');
const express = require('express');
const app = express();

//ENDPOINTS
app.get('/math/circle/:r', function (req, res) {
  let radius = req.params.r;
  let area = Math.PI * radius * radius;
  let circum = Math.PI * 2 * radius;

  res.type("json");
  res.json({area:area, circumference:circum})
});

app.get('/hello/name', function (req, res) {
  let first = req.query.first;
  let last = req.query.last;
  if(!first && last){
    res.status(400).send("Error: Missing required GET parameters: first")
  }
  else if(!last && first){
    res.status(400).send("Error: Missing required GET parameters: last")
  }
  else if (!(first && last)){
    res.status(400).send("Error: Missing required GET parameters: first, last")
  }
  else{
    res.type("text")
    res.send("Hello " + first + " " + last + "!")
  }
});

app.use(express.static('public'));
const PORT = process.env.PORT || 8000;
app.listen(PORT);