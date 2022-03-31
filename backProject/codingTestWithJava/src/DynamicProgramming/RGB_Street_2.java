package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB_Street_2 {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/17404
        // https://dragon-h.tistory.com/31

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int INF = 1_000 * 1_000;
        int[][] dp = new int[N+1][3]; // 0:빨, 1:초, 2:파
        int[][] cost = new int[N+1][3];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int answer = INF;
        for(int i=0; i<3; i++){
            // 시작 색 선택
            for(int j=0; j<3; j++){
                if(i==j) dp[1][j] = cost[1][j];
                else dp[1][j] = INF;
            }
            // i-1, i, i+1 서로 다른 색
            for (int j=2; j<=N; j++) {
                dp[j][0] = Math.min(dp[j-1][1], dp[j-1][2]) + cost[j][0];
                dp[j][1] = Math.min(dp[j-1][0], dp[j-1][2]) + cost[j][1];
                dp[j][2] = Math.min(dp[j-1][0], dp[j-1][1]) + cost[j][2];
            }
            // 시작 색과 다른 마지막 색
            for(int j=0; j<3; j++)
                if(j!=i) answer = Math.min(answer, dp[N][j]);
        }

        System.out.println(answer);
    }
}
