package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NaM_5 {

    static int[] arr;
    static int N, M;
    static boolean[] able, visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/15654

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        st = new StringTokenizer(br.readLine());
        able = new boolean[10_001];
        visit = new boolean[10_001];
        for(int i=0; i<N; i++){
            able[Integer.parseInt(st.nextToken())] = true;
        }
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

        for(int i=1; i<able.length; i++){
            if(able[i]&&!visit[i]){
                visit[i] = true;
                arr[depth] = i;
                dfs(depth+1);
                visit[i] = false;
            }
        }
    }
}
