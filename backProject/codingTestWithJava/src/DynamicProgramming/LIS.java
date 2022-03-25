package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LIS {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/11053
        // https://developer-mac.tistory.com/71

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        dp[0] = 1;
		for(int i=1; i<N; i++){
			dp[i] = 1;
			for(int j=0; j<i; j++){
				if(A[j]<A[i] && dp[i]==dp[j]){
					dp[i] = dp[j] + 1;
				}
			}
		}

		int max = 0;
		for(int i : dp) {
			max = Math.max(max, i);
		}

		System.out.println(max);
    }
}
