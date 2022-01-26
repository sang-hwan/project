package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Snake {

    static int N; // 보드의 크기
    static int K; // 사과의 개수
    static int L; // 뱀의 방향 변환 횟수
    static int time; // 게임 시간
    static int[][] board; // 보드
    static List<int[]> snake; // 뱀의 몸통 위치(x,y)
    // 0:우, 1:하, 2:좌, 3:상
    // D(우) index++
    // L(좌) index--
    static int index = 0; // 시작은 오른쪽으로 출발
    static int[] dx = {0, 1, 0, -1}; // 상하
    static int[] dy = {1, 0, -1, 0}; // 좌우
    static Map<Integer, String> dir; // 뱀의 방향

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/3190
        // https://yubh1017.tistory.com/48

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 보드 크기
        K = Integer.parseInt(br.readLine()); // 사과 개수

        board = new int[N+1][N+1]; // N*N 보드

        // 사과 위치
        int row;
        int col;
        for(int i=0; i<K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());

            board[row][col] = 1;
        }

        // 시간에 따른 뱀의 방향 전환
        dir = new HashMap<>();
        L = Integer.parseInt(br.readLine());
        for(int i=0; i<L; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int timeInfo = Integer.parseInt(st.nextToken());
            String dirInfo = st.nextToken();

            dir.put(timeInfo, dirInfo);
        }

        // 뱀의 이동
        snake = new LinkedList<>();
        snake.add(new int[]{1, 1});
        time = 0;
        int nx, ny; // 다음 위치
        int cx, cy; // 현재 위치
        cx = 1;
        cy = 1;
        while(true){
            time++;

            nx = cx + dx[index];
            ny = cy + dy[index];

            if(isFinish(nx, ny)) break;

            if(board[nx][ny]==1){ // 사과가 있을 때
                board[nx][ny] = 0;
                snake.add(new int[] {nx, ny}); // 머리 정보 변경
            }else{ // 사과가 없을 때
                snake.add(new int[] {nx, ny}); // 머리 정보 변경
                snake.remove(0); // 꼬리 제거
            }

            cx = nx;
            cy = ny;

            // 시간이 지나가다 방향 전환 시간에 도달하면
            if(dir.containsKey(time)){
                // D(우) 방향일 경우
                if(dir.get(time).equals("D")){
                    index++;
                    if(index==4) index = 0;
                }
                if(dir.get(time).equals("L")){
                    index--;
                    if(index==-1) index = 3;
                }
            }
        }
        System.out.println(time);
    }

    // 게임이 끝나는지 확인
    static boolean isFinish(int nx, int ny){
        // 벽에 부딪히면
        if(nx<1||ny<1||nx>N||ny>N) return true;

        // 자기 몸통에 닿으면
        for(int i=0; i<snake.size(); i++){
            if(nx==snake.get(i)[0]&&ny==snake.get(i)[1]) return true;
        }

        return false;
    }
}
