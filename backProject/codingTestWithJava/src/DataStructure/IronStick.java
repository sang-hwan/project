package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class IronStick {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/10799
        // https://steady-coding.tistory.com/10

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stk = new Stack<>();
        int result = 0;
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i)=='('){
                stk.push('(');
                continue;
            }
            if(input.charAt(i)==')'){
                stk.pop();
                if(input.charAt(i-1)=='('){
                    result += stk.size();
                }else{
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
