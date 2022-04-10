#include<stdio.h>
#include<stdbool.h>
#define max_size 100
typedef struct Stacktype{
    int stack[max_size];
    int top;
}Stacktype;

void Stack_init(Stacktype*s){
    s->top = -1;
}

void Stack_push(Stacktype*s, int item){
    s->stack[++(s->top)] = item;
    return;
}

bool is_empty(Stacktype*s){
    return s->top == -1;
}

int Stack_pop(Stacktype*s){
    int t = s->stack[s->top];
    s->stack[s->top] = 0;
    s->top--;
    return t;
}

int main(void){
    Stacktype s;
    Stack_init(&s);
    char input[max_size] = {};
    printf("괄호 입력 : ");
    scanf_s("%s", input, sizeof(input));
    printf("괄호 번호 : ");
    int i = 0, count = 1;
    while(input[i] != NULL){
        if(input[i] == '('){
            Stack_push(&s, count);
            printf("%d", count);
            count++;
        }else{
            printf("%d", Stack_pop(&s));
        }
        i++;
    }
    return 0;
}