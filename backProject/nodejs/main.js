// 출처: https://www.youtube.com/watch?v=VGZTn1diz_I&list=PLuHgQVnccGMA9QQX5wqj6ThK7t2tsGxjm&index=8&ab_channel=%EC%83%9D%ED%99%9C%EC%BD%94%EB%94%A9

var http = require('http');
var fs = require('fs');
var app = http.createServer(function(request,response){
    var url = request.url;
    if(request.url == '/'){
      url = '/index.html';
    }
    if(request.url == '/favicon.ico'){
      return response.writeHead(404);
    }
    response.writeHead(200);
    console.log(__dirname + url);
    response.end(fs.readFileSync(__dirname + url));
 
});
app.listen(3000);