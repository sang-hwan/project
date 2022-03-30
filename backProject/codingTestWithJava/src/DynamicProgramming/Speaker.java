package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Speaker {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/9465

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            long[][] dp = new long[N+1][3]; // 0 1 2 => not up down
            StringTokenizer st = new StringTokenizer(br.readLine()); // up
            for(int j=1; j<=N; j++){
                dp[j][1] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine()); // down
            for(int j=1; j<=N; j++){
                dp[j][2] = Integer.parseInt(st.nextToken());
            }
            for(int j=2; j<=N; j++){
                dp[j][0] += Math.max(dp[j-1][0], Math.max(dp[j-1][1], dp[j-1][2]));
                dp[j][1] += Math.max(dp[j-1][0], dp[j-1][2]);
                dp[j][2] += Math.max(dp[j-1][0], dp[j-1][1]);
            }
            sb.append(Math.max(dp[N][0], Math.max(dp[N][1], dp[N][2]))+"\n");
        }
        System.out.println(sb);
    }    
}
