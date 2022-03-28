package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfSquares {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/1699
        // https://geehye.github.io/baekjoon-1699/#

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        dp[1] = 1;
        for(int i=2; i<=N; i++){
            dp[i] = i;
            for(int j=1; j*j<=i; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
            }
        }
        System.out.println(dp[N]);
    }
}
