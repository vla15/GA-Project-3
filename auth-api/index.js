const express = require('express');
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