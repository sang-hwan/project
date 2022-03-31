package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FillTheTile {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/2133
        // https://yabmoons.tistory.com/536

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N%2!=0){
            System.out.println(0);
        }else{
            long[] dp = new long[N+1];
            dp[0] = 1;
            dp[2] = 3;
            if(N>=4) dp[4] = 11;
            if(N>=6){
                for(int j=6; j<=N; j+=2){
                    for(int i=2; i<=j; i+=2){
                        if(i==2){
                            dp[j] += dp[j-i]*dp[2];
                        }else{
                            dp[j] += dp[j-i]*2;
                        }
                    }
                }
            }
            System.out.println(dp[N]);
        }
    }
}
