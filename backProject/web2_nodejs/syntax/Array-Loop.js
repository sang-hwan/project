// 출처: https://www.youtube.com/watch?v=tzJ2K3Yp89I&list=PLuHgQVnccGMA9QQX5wqj6ThK7t2tsGxjm&index=29&ab_channel=%EC%83%9D%ED%99%9C%EC%BD%94%EB%94%A9

var number = [1, 400, 12, 34, 5];
var i = 0;
var total = 0;
while(i<number.length){
    total = total + number[i];
    i = i+1;
}
console.log(`total : ${total}`);