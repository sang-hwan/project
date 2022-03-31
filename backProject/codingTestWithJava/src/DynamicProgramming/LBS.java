package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LBS {

    static int N;
	static int[] A;
	static int[] r_dp;
	static int[] l_dp;

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/11054
        // https://st-lab.tistory.com/136

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		r_dp = new int[N+1]; // LIS
		l_dp = new int[N+1]; // LDS
		A = new int[N+1];
 
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
 
		LIS();
		LDS();
		
		int max = 0;
		for(int i=1; i<=N; i++){
			if(max < r_dp[i]+l_dp[i]){
				max = r_dp[i]+l_dp[i];
			}
		}
 
		System.out.println(max-1);
	}
	
	static void LIS(){
		for(int i=1; i<=N; i++){
			r_dp[i] = 1;
			for(int j=1; j<i; j++) {
				if(A[j]<A[i] && r_dp[i]==r_dp[j]){
					r_dp[i] = r_dp[j]+1;
				}
			}
		}
	}
 
	static void LDS(){
		for(int i=N; i>=1; i--){
			l_dp[i] = 1;
			for (int j=N; j>i; j--){
				if(A[j]<A[i] && l_dp[i]==l_dp[j]){
					l_dp[i] = l_dp[j]+1;
				}
			}
		}
	}
}
