package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackSequence {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/1874
        // https://st-lab.tistory.com/182

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack stack = new Stack();

        int n = Integer.parseInt(br.readLine());

        int start = 0;

        while(n-- > 0){
            int value = Integer.parseInt(br.readLine());

            if(value>start){
                for(int i=start+1; i<=value; i++){
                    stack.push(i);
                    sb.append("+\n");
                }
                start = value;
            }else if((int)stack.peek()!=value){
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append("-\n");
        }
        System.out.println(sb);
    }
}
