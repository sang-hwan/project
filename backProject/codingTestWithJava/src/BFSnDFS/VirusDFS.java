package BFSnDFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class VirusDFS {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N; // 노드 수
    static int M; // 간선 수
    static int arrM[][]; // 간선 표기 이중 배열
    static boolean check[]; // 지나간 노드 체크 배열
    static int cnt = 0; // 감염 노드 수

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/2606
        // https://fbtmdwhd33.tistory.com/28

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arrM = new int[N+1][N+1];

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arrM[x][y] = arrM[y][x] = 1;
        }

        check = new boolean[N+1];
        getDFS(1); // getDFS 호출

        bw.write(cnt-1+"\n");
        bw.flush();
        bw.close();
    }

    static void getDFS(int start){
        if(check[start]) return;

        check[start] = true;
        cnt++;

        for(int i=1; i<=N; i++){
            if(arrM[start][i]==1&&!check[i]){
                getDFS(i);
            }
        }
    }
}
