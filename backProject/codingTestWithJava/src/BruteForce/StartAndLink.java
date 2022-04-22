package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartAndLink{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] S;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/14889
        // https://st-lab.tistory.com/122

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        visit = new boolean[N];
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                S[i][j] = Integer.parseInt(input[j]);
            }
        }
        search(0, 0);
        System.out.println(min);
    }

    static void search(int idx, int cnt){
        if(cnt==N/2){
            diff();
            return;
        }

        for(int i=idx; i<N; i++){
            if(!visit[i]){
                visit[i] = true;
                search(i+1, cnt+1);
                visit[i] = false;
            }
        }
    }

    static void diff(){
        int team_start = 0;
        int team_link = 0;

        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){                    
                if(visit[i]&&visit[j]){
                    team_start += (S[i][j] + S[j][i]);
                }else if(!visit[i]&&!visit[j]){
                    team_link += (S[i][j] + S[j][i]);
                }
            }
        }

        int val = Math.abs(team_start-team_link);

        if(val==0){
            System.out.println(val);
            System.exit(0);
        }

        min = Math.min(min, val);
    }
}