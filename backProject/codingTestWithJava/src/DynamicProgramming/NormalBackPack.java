package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NormalBackPack{

    static int N, K;
    static int[][] item, dp;

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/12865
        // https://velog.io/@yanghl98/%EB%B0%B1%EC%A4%80-12865-%ED%8F%89%EB%B2%94%ED%95%9C-%EB%B0%B0%EB%82%AD-JAVA%EC%9E%90%EB%B0%94

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 물건 수 N, 무게 제한 K
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 각 물건의 무게 item[i][0], 가치 item[i][1]
        item = new int[N+1][2];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            item[i][0] = Integer.parseInt(st.nextToken()); // W
            item[i][1] = Integer.parseInt(st.nextToken()); // V
        }

        // dp
        int[][] dp = new int[N+1][K+1];
        for(int k=1; k<=K; k++){
            for(int i=1; i<=N; i++){
                dp[i][k] = dp[i-1][k];
                if(k-item[i][0]>=0){
                    dp[i][k] = Math.max(dp[i-1][k], item[i][1]+dp[i-1][k-item[i][0]]);
                }
            }
        }

        System.out.println(dp[N][K]);

    }
}