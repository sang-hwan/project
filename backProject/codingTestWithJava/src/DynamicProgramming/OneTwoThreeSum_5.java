package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OneTwoThreeSum_5 {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/15990
        // https://pangtrue.tistory.com/317

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int MOD = 1_000_000_009;
        int T = Integer.parseInt(br.readLine());
        long[][] dp = new long[100_001][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        for(int i=4; i<=100_000; i++){
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % MOD;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % MOD;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % MOD;
        }

        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            long result = (dp[n][1]+dp[n][2]+dp[n][3]) % MOD;
            sb.append(result+"\n");
        }

        System.out.println(sb);
    }
}
