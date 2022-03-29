package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zoo {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/1309
        // https://sundries-in-myidea.tistory.com/78

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long MOD = 9901;
        int N = Integer.parseInt(br.readLine());
        // dp[N][0] 해당 줄에 사자가 없음
        // dp[N][1] 해당 줄의 왼쪽 칸에 사자가 있음
        // dp[N][2] 해당 줄의 오른쪽 칸에 사자가 있음
        long[][] dp = new long[N+1][3];
        dp[1][0] = dp[1][1] = dp[1][2] = 1;
        for(int i=2; i<=N; i++){
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD;
        }
        long sum = 0;
        for(int i=0; i<3; i++){
            sum += dp[N][i];
        }
        System.out.println(sum%MOD);
    }
}
