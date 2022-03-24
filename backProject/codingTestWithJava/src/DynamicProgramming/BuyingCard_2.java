package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BuyingCard_2 {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/16194
        // https://developer-mac.tistory.com/70

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] P = new int[N+1];
        int[] dp = new int[N+1];
        for(int i=1; i<=N; i++){
            P[i] = Integer.parseInt(st.nextToken());
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i=1; i<=N; i++){
            for(int j=1; j<=i; j++){
                dp[i] = Math.min(dp[i], dp[i-j]+P[j]);
            }
        }
        System.out.println(dp[N]);
    }
}
