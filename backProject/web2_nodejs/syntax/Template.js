// 출처: https://www.youtube.com/watch?v=9GWjNcV96Ws&list=PLuHgQVnccGMA9QQX5wqj6ThK7t2tsGxjm&index=13&ab_channel=%EC%83%9D%ED%99%9C%EC%BD%94%EB%94%A9

var name = 'k8805';
var letter = 'Dear'+name+'\n\nLorem Ipsum is simply dummy text of the printing and typesetting industry.'+name+'Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries,'+name+'but also the leap into electronic typesetting, egoing remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages,'+name+'and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.'+name;

var letter = `Dear
 ${name} 
 Lorem Ipsum is simply dummy text of the printing and typesetting industry. ${name} Lorem Ipsum has been the industry\`s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, ${name} but also the leap into electronic typesetting, egoing remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, ${name} and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. ${name}`;

console.log(letter);