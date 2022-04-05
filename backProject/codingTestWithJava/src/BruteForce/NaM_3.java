package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NaM_3 {

    static int[] arr;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/15651

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int depth){
        if(depth==M){
            for(int val:arr){
                sb.append(val+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++){
            arr[depth] = i+1;
            dfs(depth+1);
        }
    }

}
