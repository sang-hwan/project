package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LDS {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/11722

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N+1];
        for(int i=1; i<=N; i++){
            dp[i] = 1;
            for(int j=1; j<i; j++){
                if(A[i]<A[j]&&dp[j]==dp[i]){
                    dp[i] = dp[j]+1;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++){
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
