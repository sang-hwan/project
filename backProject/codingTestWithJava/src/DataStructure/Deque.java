package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Deque {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/10866
        // https://velog.io/@kimmjieun/%EB%B0%B1%EC%A4%80-10866%EB%B2%88-%EB%8D%B1-Java-%EC%9E%90%EB%B0%94

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String[] order = br.readLine().split(" ");

            switch(order[0]){
                case "push_front":
                    deque.addFirst(Integer.parseInt(order[1]));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(order[1]));
                    break;
                case "pop_front":
                    if(deque.isEmpty()){
                        sb.append(-1+"\n");
                    }else{
                        sb.append(deque.pollFirst()+"\n");
                    }
                    break;
                case "pop_back":
                    if(deque.isEmpty()){
                        sb.append(-1+"\n");
                    }else{
                        sb.append(deque.pollLast()+"\n");
                    }
                    break;
                case "size":
                    sb.append(deque.size()+"\n");
                    break;
                case "empty":
                    if(deque.isEmpty()){
                        sb.append(1+"\n");
                    }else{
                        sb.append(0+"\n");
                    }
                    break;
                case "front":
                    if(deque.isEmpty()){
                        sb.append(-1+"\n");
                    }else{
                        sb.append(deque.peekFirst()+"\n");
                    }
                    break;
                case "back":
                    if(deque.isEmpty()){
                        sb.append(-1+"\n");
                    }else{
                        sb.append(deque.peekLast()+"\n");
                    }
                    break;
            }
        }

        System.out.println(sb);
        
    }
}
