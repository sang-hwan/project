package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ConsecutiveSum_2 {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/13398
        // https://steady-coding.tistory.com/181

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // dp[n][0]: 특정 수 제거 x
        // dp[n][1]: 특정 수 제거 o
        int[][] dp = new int[n+1][2];
        dp[1][0] = dp[1][1] = arr[1];

        int max = arr[1];
        for(int i=2; i<=n; i++){
            dp[i][0] = Math.max(dp[i-1][0]+arr[i], arr[i]);
            // i번째 지워졌을때 => dp[i-1][0]
            // i번째 이전의 수를 지웠을때 => dp[i-1][1]+arr[i]
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]+arr[i]);
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.println(max);
    }
}
