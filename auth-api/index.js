const express = require('express')

const Eureka = require('eureka-js-client').Eureka;
const client = new Eureka({
  instance: {
    app: 'auth',
    hostName: 'auth',
    ipAddr: 'auth',
    statusPageUrl: 'http://auth:3000',
    port: {
      '$': 3000,
      '@enabled': 'true',
    },
    vipAddress: 'auth',
    dataCenterInfo: {
      '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
      name: 'MyOwn',
    }
  },
  eureka: {
    host: 'eureka',
    port: 8761,
    servicePath: '/eureka/apps/'
  }
});

client.logger.level('debug');

setTimeout(function () {
  client.start(function (error) {
    console.log(error || 'complete');
  });
}, 180000);

const app = express();
app.get('/', (req, res) => {
  console.log('firing off');
  res.status(200).send('hello we are up and running');
})

app.listen(3000, err => {
  if (err) {
    console.log('errror', err)
  } else {
    console.log('Listening in on port number 8084');
  }
})