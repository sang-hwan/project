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

public class MinCost{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int INF = 1_000_000_000;
    static int N, M;
    static ArrayList<ArrayList<Node>> list;
    static int[] cost;

    public static void main(String[] args) throws IOException{
        // 출처: 
        // https://www.acmicpc.net/problem/1916

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        list = new ArrayList<>();
        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(start).add(new Node(end, weight));
        }
        
        cost = new int[N+1];
        Arrays.fill(cost, INF);

        st = new StringTokenizer(br.readLine());
        int targetS = Integer.parseInt(st.nextToken());
        int targetE = Integer.parseInt(st.nextToken());

        dijkstra(targetS);
        
        System.out.println(cost[targetE]);
    }

    static void dijkstra(int start){
        PriorityQueue<Node> priorityQ = new PriorityQueue<>();
        boolean[] check = new boolean[N+1];
        priorityQ.add(new Node(start, 0));
        cost[start] = 0;

        while(!priorityQ.isEmpty()){
            Node curNode = priorityQ.poll();
            int cur = curNode.end;

            if(check[cur]==true) continue;
            check[cur] = true;

            for(Node node: list.get(cur)){
                if(cost[node.end] > cost[cur] + node.weight){
                    cost[node.end] = cost[cur] + node.weight;
                    priorityQ.add(new Node(node.end, cost[node.end]));
                }
            }
        }
    }
}