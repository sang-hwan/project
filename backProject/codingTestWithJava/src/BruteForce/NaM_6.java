package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NaM_6 {

    static int N, M;
    static int[] arr;
    static boolean[] able;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/15655

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        able = new boolean[10_001];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            able[Integer.parseInt(st.nextToken())] = true;
        }
        dfs(1, 0);
        System.out.println(sb);
    }

    static void dfs(int at, int depth){
        if(depth==M){
            for(int val:arr){
                sb.append(val+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=at; i<10_001; i++){
            if(able[i]){
                arr[depth] = i;
                dfs(i+1, depth+1);
            }
        }
    }
}
