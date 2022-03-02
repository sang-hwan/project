package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MyStack {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/10828

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        InnerMyStack stack = new InnerMyStack(N);
        int x = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            switch(order){
                case "push":
                    x = Integer.parseInt(st.nextToken());
                    stack.push(x);
                    break;
                case "pop":
                    sb.append(stack.pop()+"\n");
                    break;
                case "size":
                    sb.append(stack.size()+"\n");
                    break;
                case "empty":
                    sb.append(stack.isEmpty()?1:0).append("\n");
                    break;
                case "top":
                    sb.append(stack.top()+"\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    static class InnerMyStack{
        private int[] stack;
        private int Index = 0;

        InnerMyStack(){}
        InnerMyStack(int number){stack = new int[number];}

        public void push(int x){
            stack[Index] = x;
            Index++;
        }

        public int size(){
            return Index;
        }

        public boolean isEmpty(){
            if(size()==0){
                return true;
            }else{
                return false;
            }
        }

        public int pop(){
            if(isEmpty()){
                return -1;
            }else{
                Index--;
                return stack[Index];
            }
        }

        public int top(){
            if(isEmpty()){
                return -1;
            }else{
                return stack[Index-1];
            }
        }
    }
}
