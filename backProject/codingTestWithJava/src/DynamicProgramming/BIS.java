package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BIS {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/11055
        // https://fbtmdwhd33.tistory.com/77

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N+1];
        long[] dp = new long[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = A[1];
        for(int i=2; i<=N; i++){
            dp[i] = A[i];
            for(int j=1; j<i; j++){
                if(A[i]>A[j]){
                    dp[i] = Math.max(dp[j]+A[i], dp[i]);
                }
            }
        }
        long max = Long.MIN_VALUE;
        for(int i=1; i<=N; i++){
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
