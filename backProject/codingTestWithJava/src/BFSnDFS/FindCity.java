package BFSnDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class FindCity{
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/18352
        // https://alliwannado-start.tistory.com/36

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 도시의 개수
        int M = Integer.parseInt(st.nextToken()); // 도로의 개수
        int K = Integer.parseInt(st.nextToken()); // 최단 거리
        int X = Integer.parseInt(st.nextToken()); // 출발 도시

        int[] distance = new int[300001]; // 최대 도시 개수 300,000
        ArrayList<ArrayList<Integer>> vector = new ArrayList<>(); // 도로 방향

        for(int i=0; i<=N; i++){
            vector.add(new ArrayList<>());
            distance[i] = -1;
        }

        distance[X] = 0; // 출발 도시에서 출발 도시로 가는 거리: 0

        // A 에서 B 로 가는 도로
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            vector.get(A).add(B);
        }

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(X); // X 도시에서 출발
        while(!queue.isEmpty()){ 
            int tmp = queue.poll();
            for(int i=0; i<vector.get(tmp).size(); i++){ // 타겟 도시의 도로 수 만큼 반복
                int next = vector.get(tmp).get(i); // 타겟 도시에서 i 도시로 가는 도로가 설치되어 있으면 이동
                if(distance[next]==-1){ // 방문한적 없으면
                    distance[next] = distance[tmp]+1; // 출발도시에서 next 도시까지 거리
                    queue.add(next); // 방문한 도시에서 다시 거리 측정
                }
            }
        }

        // 출발 도시 X 에서 최단 거리 K 인 도시 번호
        boolean check = false;
        for(int i=0; i<=N; i++){
            if(distance[i]==K){
                System.out.println(i);
                check = true;
            }
        }
        if(!check) System.out.println(-1);
    }
}