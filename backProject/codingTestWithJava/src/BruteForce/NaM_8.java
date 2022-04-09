package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NaM_8 {

    static int N, M;
    static int[] arr;
    static boolean[] able;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/15657

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        st = new StringTokenizer(br.readLine());
        able = new boolean[10_001];
        for(int i=0; i<N; i++){
            able[Integer.parseInt(st.nextToken())] = true;
        }
        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int depth){
        if(depth==M){
            for(int val : arr){
                sb.append(val+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=10_000; i++){
            if(able[i]){
                if(depth==0){
                    arr[depth] = i;
                    dfs(depth+1);
                }else{
                    if(arr[depth-1]<=i){
                        arr[depth] = i;
                        dfs(depth+1);
                    }
                }
            }
        }
    }
}
