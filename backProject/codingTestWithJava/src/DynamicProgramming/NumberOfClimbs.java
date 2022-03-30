package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumberOfClimbs{
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/11057

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long MOD = 10_007;
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[1001][10];
        Arrays.fill(dp[1], 1);
        for(int i=2; i<=1000; i++) dp[i][0] = 1;
        for(int i=2; i<=1000; i++){
            for(int j=1; j<=9; j++){
                for(int k=0; k<=j; k++){
                    dp[i][j] += (dp[i-1][k] % MOD);
                }
            }
        }
        long sum = 0;
        for(int i=0; i<=9; i++){
            sum += dp[N][i];
        }
        System.out.println(sum%MOD);
    }
}