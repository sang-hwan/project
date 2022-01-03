// 출처: https://www.youtube.com/watch?v=X0wfdOJzq_Y&list=PLuHgQVnccGMA9QQX5wqj6ThK7t2tsGxjm&index=18&ab_channel=%EC%83%9D%ED%99%9C%EC%BD%94%EB%94%A9

// nodejs homepage → documentation → node -v match → file system → readfile
var fs = require('fs');
fs.readFile('sample.txt', 'utf-8', function(err, data){
    console.log(data);
});