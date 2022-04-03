package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RemoteController {

    static boolean[] broken;
    
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/1107
        // https://velog.io/@hammii/%EB%B0%B1%EC%A4%80-1107-%EB%A6%AC%EB%AA%A8%EC%BB%A8-java

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        broken = new boolean[10]; // 0 to 9
        if(M!=0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int result = Math.abs(N-100); // current chnnel is 100
        for(int i=0; i<=999_999; i++){ // button click case: 0 to 999_999
            int len = check(i); // this case num button click count
            if(len>0){ // this case not include broken button
                int press = Math.abs(N-i); // +, - button click count
                result = Math.min(result, len + press);
            }
        }
        System.out.println(result);
    }

    static int check(int i){
        if(i==0){ // move 0 channel
            if(broken[0]){ // 0 button broken
                return 0;
            }else{ // 0 button not broken
                return 1;
            }
        }
        
        int len = 0;
        while(i>0){
            if(broken[i%10]){ // is broken button
                return 0;
            }
            i /= 10;
            len += 1; // num button click count
        }
        return len;
    }
}
