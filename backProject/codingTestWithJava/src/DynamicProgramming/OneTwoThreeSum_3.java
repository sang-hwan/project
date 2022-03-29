package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OneTwoThreeSum_3 {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/15988
        // https://velog.io/@jkh9615/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-12101-1-2-3-%EB%8D%94%ED%95%98%EA%B8%B0-3-Java

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int MOD = 1_000_000_009;
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long [1_000_001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4; i<=1_000_000; i++){
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % MOD;
        }
        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n] % MOD);
        }
    }
}
