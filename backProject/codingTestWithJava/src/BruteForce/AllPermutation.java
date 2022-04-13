package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AllPermutation {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] arr, able;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/10974

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        able = new int[N+1];
        visit = new boolean[N+1];
        for(int i=1; i<=N; i++){
            able[i] = i;
        }
        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int depth){
        if(depth==N){
            for(int val:arr){
                sb.append(val+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            if(!visit[i]){
                visit[i] = true;
                arr[depth] = able[i];
                dfs(depth+1);
                visit[i] = false;
            }
        }
    }
}
