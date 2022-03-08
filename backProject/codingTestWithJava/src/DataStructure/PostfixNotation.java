package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostfixNotation {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/1918
        // https://gre-eny.tistory.com/229

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stk = new Stack<>();
        String prefix = br.readLine();
        for(Character c:prefix.toCharArray()){
            if('A'<=c&&c<='Z'){
                sb.append(c);
            }else if(c=='('){
                stk.push(c);
            }else if(c==')'){
                while(!stk.isEmpty()){
                    if(stk.peek()=='('){
                        stk.pop();
                        break;
                    }
                    sb.append(stk.pop());
                }
            }else{
                while(!stk.isEmpty()&&priority(stk.peek())>=priority(c)){
                    sb.append(stk.pop());
                }
                stk.push(c);
            }
        }

        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        System.out.println(sb.toString());
    }

    static int priority(char operator){
        if(operator=='('||operator==')'){
            return 0;
        }else if(operator=='+'||operator=='-'){
            return 1;
        }else if(operator=='*'||operator=='/'){
            return 2;
        }
        return -1;
    }
}
