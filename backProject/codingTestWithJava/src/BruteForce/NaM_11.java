package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class NaM_11{

    static int N, M;
    static int[] arr, able;
    static StringBuilder total_sb = new StringBuilder();
    static HashSet<String> duplicate_check = new HashSet<>();
    

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/15665

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        able = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            able[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(able);
        dfs(0);
        System.out.println(total_sb);
    }

    static void dfs(int depth){
        if(depth==M){
            StringBuilder sb = new StringBuilder();
            for(int val:arr){
                sb.append(val+" ");
            }
            if(!duplicate_check.contains(sb.toString())){
                total_sb.append(sb.toString()).append("\n");
                duplicate_check.add(sb.toString());
            }
            return;
        }

        for(int i=0; i<N; i++){
            arr[depth] = able[i];
            dfs(depth+1);
        }
    }
}