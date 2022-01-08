package BFSnDFS;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFSnBFS{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N; // 노드수
    static int M; // 간선수
    static int V; // 시작 노드
    static int arr[][]; // 간선 좌표를 위한 이중 배열
    static boolean check[]; // 지나간 노드 표기를 위한 boolean 배열
    static StringBuilder sb = new StringBuilder(); // 경로 출력

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/1260
        // https://m.blog.naver.com/lm040466/221787478911
        // DFS와 BFS 문제

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        check = new boolean[N+1];

        // 간선 표기
        int x;
        int y;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            arr[x][y] = arr[y][x] = 1;
        }

        getDFS(V); // DFS 호출
        sb.append("\n");
        bw.write(sb.toString());

        check = new boolean[N+1]; // 지나간 노드 표기 초기화
        sb = new StringBuilder(); // StringBuilder 초기화

        getBFS(); // BFS 호출
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    // DFS 함수
    public static void getDFS(int V){

        check[V] = true;
        sb.append(V+" ");

        for(int i=1; i<=N; i++){
            if(arr[V][i]==1&&check[i]==false){
                getDFS(i);
            }
        }
    }

    // BFS 함수
    public static void getBFS(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(V);
        check[V] = true;
        sb.append(V+" ");

        while(!queue.isEmpty()){
            int tmp = queue.poll();

            for(int i=1; i<=N; i++){
                if(arr[tmp][i]==1&&check[i]==false){
                    queue.offer(i);
                    check[i] = true;
                    sb.append(i+" ");
                }
            }
        }
    }
}