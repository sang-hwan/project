package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxDifference{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, max, tmp;
    static int arr[], able[];
    static boolean visit[];

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/10819

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        able = new int[N];
        visit = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            able[i] = Integer.parseInt(st.nextToken());
        }
        max = 0;
        dfs(0);
        System.out.println(max);
    }

    static void dfs(int depth){
        if(depth==N){
            tmp = 0;
            for(int i=0; i<N-1; i++){
                tmp += Math.abs(arr[i]-arr[i+1]);
            }
            max = Math.max(tmp, max);
            // for(int val:arr){
            //     System.out.print(val+" ");
            // }
            // System.out.println("-> max: "+max);
        }

        for(int i=0; i<N; i++){
            if(!visit[i]){
                visit[i] = true;
                arr[depth] = able[i];
                dfs(depth+1);
                visit[i] = false;
            }
        }
    }
}