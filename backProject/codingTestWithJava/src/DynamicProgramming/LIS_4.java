package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LIS_4 {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/14002

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        dp[0] = 1;
        for(int i=1; i<N; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(A[i]>A[j] && dp[i]==dp[j]){
                    dp[i] = dp[j]+1;
                }
            }
        }
        int max = 0;
        for(int i:dp){
            max = Math.max(max, i);
        }
        System.out.println(max);

        int[] output = new int[max];
        for(int i=N-1; i>=0; i--){
            if(dp[i]==max){
                output[max-1] = A[i];
                max--;
            }
        }
        for(int i:output) System.out.print(i+" ");
    }
}