package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TSP_2{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] W;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/10971
        // https://lotuslee.tistory.com/92

        N = Integer.parseInt(br.readLine());
        W = new int[N+1][N+1];
        visit = new boolean[N+1];

        for(int i=1; i<=N; i++){
            String[] row = br.readLine().split(" ");
            for(int j=1; j<=N; j++){
                W[i][j] = Integer.parseInt(row[j-1]);
            }
        }

        visit[1] = true;
        dfs(1, 1, 1, 0);
        System.out.println(min);
    }

    static void dfs(int start, int now, int cnt, int cost){
        if(now==start&&cost>0){
            min = Math.min(min, cost);
            return;
        }

        for(int i=1; i<=N; i++){
            if(W[now][i]>0){
                if(i==start&&cnt==N){ // return to start point
                    cost += W[now][i];
                    dfs(start, i, cnt+1, cost);
                }else if(!visit[i]){ // first visit
                    visit[i] = true;
                    cost += W[now][i];
                    dfs(start, i, cnt+1, cost);
                    cost -= W[now][i]; // rollback to cost of current depth
                    visit[i] = false;
                }
            }
        }
    }
}