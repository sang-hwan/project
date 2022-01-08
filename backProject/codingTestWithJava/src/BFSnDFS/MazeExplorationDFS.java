package BFSnDFS;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MazeExplorationDFS{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static int maze[][];
    static boolean check[][];
    static int minVal;

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/2178
        // https://wiselog.tistory.com/163
        // 미로탐색 문제

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        check = new boolean[N][M];

        for(int i=0; i<N; i++){
            String mazeX = br.readLine();
            for(int j=0; j<M; j++){
                maze[i][j] = mazeX.charAt(j) - '0';
            }
        }

        check[0][0] = true;
        minVal = Integer.MAX_VALUE;
        getDFS(0, 0, 1);
        bw.write(minVal+"\n");
        bw.flush();
        bw.close();
    }

    public static void getDFS(int x, int y, int value){
        if(x==N-1 && y==M-1){
            minVal = Math.min(minVal, value);
            return;
        }

        if(value > minVal) return;

        if(x>0 && !check[x-1][y] && maze[x-1][y]==1){
            // 상
            check[x-1][y] = true;
            getDFS(x-1, y, value+1);
            check[x-1][y] = false;
        }
        if(x<N-1 && !check[x+1][y] && maze[x+1][y]==1){
            // 하
            check[x+1][y] = true;
            getDFS(x+1, y, value+1);
            check[x+1][y] = false;
        }
        if(y>0 && !check[x][y-1] && maze[x][y-1]==1){
            // 좌
            check[x][y-1] = true;
            getDFS(x, y-1, value+1);
            check[x][y-1] = false;
        }
        if(y<M-1 && !check[x][y+1] && maze[x][y+1]==1){
            // 우
            check[x][y+1] = true;
            getDFS(x, y+1, value+1);
            check[x][y+1] = false;
        }
    }
}