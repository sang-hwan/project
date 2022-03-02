package RecursionFunction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class ParenthesisValueRF {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        String inputValue = br.readLine();
        bw.write(checkString(inputValue)?calc(inputValue)+"\n":0+"\n");
        bw.flush();
        bw.close();
    }

    public static boolean checkString(String inputValue){
        if(inputValue.length()%2==1) return false;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<inputValue.length(); i++){
            char now = inputValue.charAt(i);
            if(now=='(' || now=='['){
                stack.push(inputValue.charAt(i));
            }else{
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if(now==')' && top!='('){
                    return false;
                }
                if(now==']' && top!='['){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static int calc(String inputValue){
        if(inputValue.length()==0){
            return 1;
        }
        int start = 0;
        int len = inputValue.length();
        char lt, rt;
        int result;
        int st=0, i=0;
        int ans = 0;
        while(i<len){
            start = i;
            lt = inputValue.charAt(i);
            rt = lt=='(' ? ')':']';
            result = lt=='(' ? 2:3;
            for(; i<len; i++){
                if(inputValue.charAt(i)==lt) st++;
                if(inputValue.charAt(i)==rt) st--;
                if(st==0){
                    result *= calc(inputValue.substring(start+1, i));
                    break;
                }
            }
            ans += result;
            i++;
        }
        return ans;
    }
}
