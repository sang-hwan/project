package RecursionFunction;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class ParenthesisLoop{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/2504
        // https://velog.io/@booorim98/BOJ-2504

        String inputValue = br.readLine();

        int mul = 1;
        int result = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<inputValue.length(); i++){
            switch(inputValue.charAt(i)){
                case '(':
                    stack.push('(');
                    mul *= 2;
                    break;
                case '[':
                    stack.push('[');
                    mul *= 3;
                    break;
                case ')':
                    if(stack.isEmpty() || stack.peek()!='('){
                        result = 0;
                        break;
                    }
                    if(inputValue.charAt(i-1)=='(') result += mul;
                    stack.pop();
                    mul /= 2;
                    break;
                case ']':
                    if(stack.isEmpty() || stack.peek()!='['){
                        result = 0;
                        break;
                    }
                    if(inputValue.charAt(i-1)=='[') result += mul;
                    stack.pop();
                    mul /= 3;
                    break;
            }
        }

        bw.write(!stack.isEmpty()? 0+"\n":result+"\n");
        bw.flush();
        bw.close();
    }
}