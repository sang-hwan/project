package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class StackSequence {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack stack = new Stack();
        ArrayList check = new ArrayList<>();
        for(int i=1; i<=n; i++){
            check.add(i);
        }
        for(int j=1; j<=n; j++){
            int value = Integer.parseInt(br.readLine());
            if(check.contains(value)){
                for(int k=(int)check.get(0); k<=value; k++){
                    stack.push(k);
                    check.remove(k);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }else{
                stack.pop();
                sb.append("-\n");
            }
        }
        System.out.println(sb);
    }
}
