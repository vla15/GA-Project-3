const express = require('express')

const app = express();
app.get('/', (req, res) => {
  res.send('hello we are up and running');
})

app.listen(8084, err => {
  if (err) {
    console.log('errror', err)
  } else {
    console.log('Listening in on port number 8084');
  }
})

const Eureka = require('eureka-js-client').Eureka;

const client = new Eureka({
  instance: {
    app: 'authservice',
    hostName: 'localhost',
    ipAddr: '127.0.0.1',
    port: {
      '$': 8084,
      '@enabled': true,
    },
    statusPageUrl: 'http://localhost:8084',
    vipAddress: 'jq.test.something.com',
    dataCenterInfo: {
      '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
      name: 'MyOwn',
    },
  },
  eureka: {
    host: 'localhost',
    port: 8761,
    servicePath: '/eureka/apps'
  },
});

client.logger.level('debug');

client.start((error) => {
  console.log(error || 'complete');
});