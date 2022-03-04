package DataStructure;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MyQueue {
    public static void main(String[] args) throws IOException{
        // 큐 문제
        // 출처:
        // https://www.acmicpc.net/problem/10845
        // https://velog.io/@cheal3/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-10845-%ED%81%90-%EC%9E%90%EB%B0%94
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        int back = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            switch(order){
                case "push":
                    back = Integer.parseInt(st.nextToken());
                    queue.add(back);
                    break;
                case "pop":
                    if(queue.isEmpty()){
                        sb.append("-1\n");
                    }else{
                        sb.append(queue.poll()+"\n");
                    }
                    break;
                case "size":
                    sb.append(queue.size()+"\n");
                    break;
                case "empty":
                    sb.append(queue.isEmpty()?1:0).append("\n");
                    break;
                case "front":
                    sb.append(queue.isEmpty()?-1:queue.peek()).append("\n");
                    break;
                case "back":
                    sb.append(queue.isEmpty()?-1:back).append("\n");
                    break;
            }
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }    
}
