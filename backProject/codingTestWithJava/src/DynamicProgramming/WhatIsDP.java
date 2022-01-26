package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WhatIsDP {

    static int N, M;
    static long[][] board;

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/14494
        // https://nyeongnyeong.tistory.com/227
        
        // N, M 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // N*M 배열
        board = new long[N+1][M+1];

        for(int i=0; i<=N; i++){
            for(int j=0; j<=M; j++){
                board[i][j] = -1;
            }
        }

        System.out.println(DP(N, M));
        
    }

    static long DP(int n, int m){
        if(n==0||m==0) return 0;
        if(n==1&&m==1) return 1;
        if(board[n][m]!=-1) return board[n][m];
        long result = (DP(n, m-1) + DP(n-1, m) + DP(n-1, m-1))%1000000007;
        board[n][m] = result;
        return result;
    }
}
