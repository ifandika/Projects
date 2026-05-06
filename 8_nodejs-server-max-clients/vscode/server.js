const http = require('http');
const server = http.createServer((req, res) => {
  res.end("Hello...");
});

server.listen(3000, () => {
  console.log('Server berjalan di http://localhost:3000');
})
