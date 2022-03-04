package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Editor1 {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/1406
        // https://dh-0419.tistory.com/94

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());

        Stack<Character> lStack = new Stack<>();
        Stack<Character> rStack = new Stack<>();

        for(int i=0; i<str.length(); i++){
            lStack.push(str.charAt(i));
        }

        while(M-- > 0){
            String[] input = br.readLine().split(" ");
            if(input[0].equals("L")&&!lStack.isEmpty()){
                rStack.push(lStack.pop());
            }else if(input[0].equals("D")&&!rStack.isEmpty()){
                lStack.push(rStack.pop());
            }else if(input[0].equals("B")&&!lStack.isEmpty()){
                lStack.pop();
            }else if(input[0].equals("P")){
                lStack.push(input[1].charAt(0));
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!lStack.isEmpty()){
            rStack.push(lStack.pop());
        }
        while(!rStack.isEmpty()){
            sb.append(rStack.pop());
        }

        System.out.println(sb);

    }
    
}
