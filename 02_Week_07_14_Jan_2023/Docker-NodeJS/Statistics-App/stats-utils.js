const osutils = require("os-utils");

const getServerStats = () => {

  const serverStats = {}

  console.log("Platform: " + osutils.platform());
  serverStats.platform = osutils.platform();

  console.log("Number of CPUs: " + osutils.cpuCount());
  serverStats.noOfCPUs = osutils.cpuCount();

  osutils.cpuUsage(function(v) {
    console.log("CPU Usage (%) : " + v);
  });

  console.log("Load Average (5m): " + osutils.loadavg(5));

  console.log("Total Memory: " + osutils.totalmem() + " MB");

  console.log("Free Memory: " + osutils.freemem() + "MB");
  serverStats.freeMemory = osutils.cpuCount() + " MB";

  console.log("Free Memory (%): " + osutils.freememPercentage());
  serverStats.freeMemoryPercentage = osutils.freememPercentage();

  const upTimeInMins = (osutils.sysUptime() / 1000) / 60;
  console.log("System Uptime (in Mins): " + upTimeInMins);
  serverStats.systemUptime = `${upTimeInMins} Mins`;

  console.log(`PORT Number is ${process.env.PORT}`);
  serverStats.port = process.env.PORT;

  return serverStats;
} 

module.exports = {getServerStats}