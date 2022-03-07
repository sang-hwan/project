package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class WordReversing_2 {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/17413
        // https://yongku.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-17413%EB%B2%88-%EB%8B%A8%EC%96%B4-%EB%92%A4%EC%A7%91%EA%B8%B0-2-%EC%9E%90%EB%B0%94Java

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stk = new Stack<>();
        boolean io = false;

        for(int i=0; i<input.length(); i++){
            if(input.charAt(i)=='<'){
                io = true;
                while(!stk.isEmpty()){
                    System.out.print(stk.pop());
                }
                System.out.print(input.charAt(i));
            }else if(input.charAt(i)=='>'){
                io = false;
                System.out.print(input.charAt(i));
            }else if(io){
                System.out.print(input.charAt(i));
            }else if(!io){
                if(input.charAt(i)==' '){
                    while(!stk.isEmpty()){
                        System.out.print(stk.pop());
                    }
                    System.out.print(input.charAt(i));
                }else{
                    stk.push(input.charAt(i));
                }
            }
        }
        while(!stk.isEmpty()){
            System.out.print(stk.pop());
        }
    }
}
