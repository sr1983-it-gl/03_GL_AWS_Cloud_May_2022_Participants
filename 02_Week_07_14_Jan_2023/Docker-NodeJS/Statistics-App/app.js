const express = require('express');
const {getServerStats} = require("./stats-utils");

const app = express();

const PORT = process.env.PORT;

if (!PORT){
  throw new Error("Port is NOT defined for the application")
}

const stats = getServerStats();
console.log("Stats " + JSON.stringify(stats));

app.get('/statistics', (req, res) => res.json(
  stats
));

app.listen(PORT, () => {
  console.log(`Application running at port ${PORT}`);
});
