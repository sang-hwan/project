package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BuyingCard{
    // 출처:
    // https://www.acmicpc.net/problem/11052
    // https://velog.io/@gloriousmin77/%EB%B0%B1%EC%A4%80-11052-%EC%B9%B4%EB%93%9C-%EA%B5%AC%EB%A7%A4%ED%95%98%EA%B8%B0-java

    static int N;
    static int[] P, dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 구입할 카드 수
        N = Integer.parseInt(br.readLine());

        // 카드 N 개가 들어있는 카드 팩 P_N 의 가격
        StringTokenizer st = new StringTokenizer(br.readLine());
        P = new int[N+1];
        for(int i=1; i<=N; i++){
            P[i] = Integer.parseInt(st.nextToken());
        }

        // 최대값 계산
        dp = new int[N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=i; j++){
                dp[i] = Math.max(dp[i], P[j]+dp[i-j]);
            }
        }

        System.out.println(dp[N]);
    }
}