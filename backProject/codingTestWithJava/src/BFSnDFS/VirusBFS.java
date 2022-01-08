package BFSnDFS;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class VirusBFS {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N; // 노드 수
    static int M; // 간선 수
    static int arrM[][]; // 간선 표기 이중 배열
    static boolean check[]; // 체크한 노드 표기 배열

    public static void main(String[] args) throws IOException{
    
        // 출처:
        // https://www.acmicpc.net/problem/2606
        // https://fbtmdwhd33.tistory.com/28

        // 노드 수와 간선 수 입력
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        // 간선 표기하는 이중 배열 입력
        arrM = new int[N+1][N+1];
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arrM[x][y] = arrM[y][x] = 1;
        }

        check = new boolean[N+1];
        bw.write(getBFS(1)+"\n"); // getBFS 호출
        bw.flush();
        bw.close();
    }

    public static Integer getBFS(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        check[start] = true;
        int cnt = 0; // 감염 노드 수

        while(!queue.isEmpty()){
            int x = queue.poll();

            for(int i=1; i<=N; i++){
                if(arrM[x][i]==1 && !check[i]){
                    queue.offer(i);
                    check[i] = true;
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
