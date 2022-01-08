package BFSnDFS;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MazeExplorationBFS{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static int[][] maze;
    static boolean[][] check;
    static int[] dx = {0, 0, -1, 1}; // x 방향 - 좌우
    static int[] dy = {-1, 1, 0, 0}; // y 방향 - 상하

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/2178
        // https://wiselog.tistory.com/163
        // 미로탐색 문제
        
        // 미로 크기
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 미로 생성
        maze = new int[N][M];
        for(int i=0; i<N; i++){
            String mazeX = br.readLine();
            for(int j=0; j<M; j++){
                maze[i][j] = mazeX.charAt(j) - '0';
            }
        }

        check = new boolean[N][M];
        check[0][0] = true;
        getBFS(0, 0); // BFS 호출

        bw.write(maze[N-1][M-1]+"\n");
        bw.flush();
        bw.close();
    }

    // BFS
    public static void getBFS(int x, int y){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        queue.offer(y);

        while(!queue.isEmpty()){
            int nowX = queue.poll();
            int nowY = queue.poll();

            for(int i=0; i<4; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX<0 || nextY<0 || nextX>=N || nextY>=M) continue;
                if(check[nextX][nextY] || maze[nextX][nextY]==0) continue;

                queue.offer(nextX);
                queue.offer(nextY);
                maze[nextX][nextY] = maze[nowX][nowY] + 1;
                check[nextX][nextY] = true;
            }
        }
    }
}