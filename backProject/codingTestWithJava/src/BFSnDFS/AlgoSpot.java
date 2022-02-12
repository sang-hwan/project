package BFSnDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point implements Comparable<Point>{
    int x, y, cnt;
    
    Point(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Point o){
        return cnt - o.cnt;
    }
}

public class AlgoSpot {

    static int[] verticality = {-1, 0, 1, 0}; // 상하
    static int[] horizontal = {0, -1, 0, 1}; // 좌우
    static int N, M;
    static int[][] maze;

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/1261
        // https://steady-coding.tistory.com/59
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로

        maze = new int[N+1][M+1];

        for(int i=1; i<=N; i++){
            String mazeRow = br.readLine();
            for(int j=1; j<=M; j++){
                maze[i][j] = Character.getNumericValue(mazeRow.charAt(j-1));
            }
        }

        int ans = getBFS(1, 1);

        System.out.println(ans);
    }
    
    static int getBFS(int x, int y){
        // 벽을 부순 개수(cnt) 를 오름차순으로 정렬
        PriorityQueue<Point> pQueue = new PriorityQueue<>();

        pQueue.offer(new Point(x, y, 0));
        boolean[][] visit = new boolean[N+1][M+1];
        visit[x][y] = true;

        int dx, dy;
        while(!pQueue.isEmpty()){
            Point p = pQueue.poll();

            // (N, M) 에 도착하면 종료
            if(p.x==N && p.y==M){
                return p.cnt;
            }

            for(int i=0; i<4; i++){
                dx = p.x + verticality[i];
                dy = p.y + horizontal[i];

                // 미로 바깥으로 나가는 경우
                if(dx<1 || dy<1 || dx>N || dy>M){
                    continue;
                }

                // 방문한 적이 없던 곳 && 벽이 없는 곳
                if(!visit[dx][dy] && maze[dx][dy]==0){
                    visit[dx][dy] = true;
                    pQueue.offer(new Point(dx, dy, p.cnt));
                }

                // 방문한 적이 없던 곳 && 벽이 있는 곳
                if(!visit[dx][dy] && maze[dx][dy]==1){
                    visit[dx][dy] = true;
                    pQueue.offer(new Point(dx, dy, p.cnt+1));
                }
            }
        }

        return 0;

    }
}
