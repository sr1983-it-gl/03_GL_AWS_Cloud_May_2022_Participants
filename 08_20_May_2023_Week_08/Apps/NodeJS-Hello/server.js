'use strict';

const express = require('express');
const app = express();

require("dotenv").config();
const path = require('path');

const os = require('os');

const networkInterfaces = os.networkInterfaces();
// console.log(networkInterfaces);

app.set("view engine", "ejs");

// Constants
const PORT = process.env.PORT || 8080;
const HOST = '0.0.0.0';

// App
app.get('/', (req, res) => {

  res.render("index", {
    server_ip: JSON.stringify(networkInterfaces)
  }
)});

// app.get('/test', (req, res) => {

//   res.json({message: "test message"});

// });



app.listen(PORT, HOST, () => {
  console.log(`Running on http://${HOST}:${PORT}`);
});