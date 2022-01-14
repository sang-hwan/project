package Sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MakeCouple{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int[] arrMen, arrWomen;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/1727
        // https://kyeahen.github.io/algorithm/BOJ-1727-%EC%BB%A4%ED%94%8C%EB%A7%8C%EB%93%A4%EA%B8%B0/

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N+1][M+1];

        arrMen = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arrMen[i] = Integer.parseInt(st.nextToken());
        }
        
        arrWomen = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            arrWomen[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrMen);
        Arrays.sort(arrWomen);

        for(int i=1; i<=arrMen.length; i++){
            for(int j=1; j<=arrWomen.length; j++){
                dp[i][j] = dp[i-1][j-1] + Math.abs(arrMen[i-1]-arrWomen[j-1]);
                
                if(i>j){ // 남자가 여자보다 많을 때
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
                }

                if(i<j){ // 여자가 남자보다 많을 때
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-1]);
                }
            }
        }

        bw.write(Integer.toString(dp[N][M]));
        bw.flush();
        bw.close();
        
    }
}