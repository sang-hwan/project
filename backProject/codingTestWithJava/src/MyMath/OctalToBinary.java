package MyMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.util.Stack;

public class OctalToBinary {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/1212
        // https://haerang94.tistory.com/365
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] binary = {"000","001","010","011","100","101","110","111"}; // 0 to 7 binary list
        String s = br.readLine();
        for(int i=0; i<s.length(); i++){
            int tmp = s.charAt(i)-'0';
            if(i==0&&tmp<4){
                if(tmp<2){
                    sb.append(binary[tmp].substring(2));
                }else{
                    sb.append(binary[tmp].substring(1));
                }
            }else{
                sb.append(binary[tmp]);
            }
        }
		
		System.out.println(sb);

        // 메모리 초과
        // Stack stk = new Stack<>();
        // int first = s.charAt(0)-'0';
        // while(first!=1){
        //     stk.push(first%2);
        //     first /= 2;
        // }
        // sb.append(first);
        // while(!stk.isEmpty()){
        //     sb.append(stk.pop());
        // }
        // if(s.length()>1){
        //     for(int i=1; i<s.length(); i++){
        //         int tmp = s.charAt(i)-'0';
        //         if(tmp==3||tmp==2){
        //             while(tmp!=1){
        //                 stk.push(tmp%2);
        //                 tmp /= 2;
        //             }
        //             sb.append("0"+tmp);
        //             while(!stk.isEmpty()){
        //                 sb.append(stk.pop());
        //             }
        //         }else if(tmp==1||tmp==0){
        //             sb.append("0"+"0"+tmp);
        //         }else{ // 4 이상
        //             while(tmp!=1){
        //                 stk.push(tmp%2);
        //                 tmp /= 2;
        //             }
        //             sb.append(tmp);
        //             while(!stk.isEmpty()){
        //                 sb.append(stk.pop());
        //             }
        //         }
        //     }
        // }
        // System.out.println(sb);
    }
}
