package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class JosephusProblem {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/1158
        // https://steady-coding.tistory.com/21

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=N; i++){
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(queue.size()!=1){
            for(int i=0; i<K-1; i++){
                queue.add(queue.poll());
            }
            sb.append(queue.poll()+", ");
        }
        sb.append(queue.poll()+">");

        System.out.println(sb);
    }
}
