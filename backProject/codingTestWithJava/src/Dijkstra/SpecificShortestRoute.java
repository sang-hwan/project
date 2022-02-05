package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int end, weight;

    public Node(int end, int weight){
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o){
        return weight - o.weight;
    }
}

public class SpecificShortestRoute{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int INF = 200_000_000;
    static int N, E;
    static ArrayList<ArrayList<Node>> list;

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/1504
        // https://steady-coding.tistory.com/82

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 노드의 개수
        E = Integer.parseInt(st.nextToken()); // 간선의 개수

        // 간선이 양방향인 인접 리스트
        list = new ArrayList<>();
        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken()); // 경유해야 되는 노드 1
        int v2 = Integer.parseInt(st.nextToken()); // 경유해야 되는 노드 2

        // 1 -> v1 -> v2 -> N으로 가는 경우
        int res1 = 0;
        res1 += dijkstra(1, v1);
        res1 += dijkstra(v1, v2);
        res1 += dijkstra(v2, N);

        // 1 -> v2 -> v1 -> N으로 가는 경우
        int res2 = 0;
        res2 += dijkstra(1, v2);
        res2 += dijkstra(v2, v1);
        res2 += dijkstra(v1, N);

        int ans = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);

        System.out.println(ans);
    }

    static int dijkstra(int start, int end){
        int[] distance = new int[N+1]; // 거리 측정
        Arrays.fill(distance, INF);

        boolean[] check = new boolean[N+1]; // 노드 경유 유무
        Arrays.fill(check, false);

        PriorityQueue<Node> pQueue = new PriorityQueue<>();
        pQueue.add(new Node(start, 0));
        distance[start] = 0;

        while(!pQueue.isEmpty()){
            Node curNode = pQueue.poll();
            int cur = curNode.end;

            if(check[cur]==true) continue;
            check[cur] = true;

            for(Node node:list.get(cur)){
                if(distance[node.end] > distance[cur] + node.weight){
                    distance[node.end] = distance[cur] + node.weight;
                    pQueue.add(new Node(node.end, distance[node.end]));
                }
            }
        }

        return distance[end];
    }
}