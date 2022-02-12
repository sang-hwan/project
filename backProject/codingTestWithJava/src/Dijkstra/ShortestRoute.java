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

public class ShortestRoute{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int INF = 100_000_000;
    static int V, E, K;
    static ArrayList<ArrayList<Node>> list;
    static int[] distance;

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/1753
        // https://dragon-h.tistory.com/20

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); // 정점의 개수
        E = Integer.parseInt(st.nextToken()); // 간선의 개수
        K = Integer.parseInt(br.readLine()); // 출발 정점
        
        list = new ArrayList<>();
        for(int i=0; i<=V; i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(start).add(new Node(end, weight));
        }
        
        distance = new int[V+1];
        Arrays.fill(distance, INF);

        StringBuilder sb = new StringBuilder();
        dijkstra(K);
        for(int i=1; i<=V; i++){
            if(distance[i]==INF) sb.append("INF\n");
            else sb.append(distance[i]+"\n");
        }

        System.out.println(sb.toString());
    }

    static void dijkstra(int start){
        PriorityQueue<Node> priorityQ = new PriorityQueue<>();
        boolean[] check = new boolean[V+1];
        priorityQ.add(new Node(start, 0));
        distance[start] = 0;

        while(!priorityQ.isEmpty()){
            Node curNode = priorityQ.poll();
            int cur = curNode.end;

            if(check[cur]==true) continue;
            check[cur] = true;

            for(Node node : list.get(cur)){
                if(distance[node.end] > distance[cur] + node.weight){
                    distance[node.end] = distance[cur] + node.weight;
                    priorityQ.add(new Node(node.end, distance[node.end]));
                }
            }
        }
    }
}