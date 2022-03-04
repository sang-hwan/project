package DataStructure;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MyQueue2 {
    public static void main(String[] args) throws IOException{
        // 큐 문제
        // 출처:
        // https://www.acmicpc.net/problem/10845
        // https://worldpeace21.tistory.com/22

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        MyQueue queue = new MyQueue(N);
        int x = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            switch(order){
                case "push":
                    x = Integer.parseInt(st.nextToken());
                    queue.push(x);
                    break;
                case "pop":
                    sb.append(queue.pop()+"\n");
                    break;
                case "empty":
                    sb.append(queue.isEmpty()?1:0).append("\n");
                    break;
                case "front":
                    sb.append(queue.front()+"\n");
                    break;
                case "back":
                    sb.append(queue.back()+"\n");
                    break;
                case "size":
                    sb.append(queue.size()+"\n");
                    break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    
    static class MyQueue{
        private int[] queue;
        private int frontIndex = 0;
        private int backIndex = -1;

        MyQueue(){}
        MyQueue(int number){queue = new int[number];}

        public void push(int x){
            queue[++backIndex] = x;
        }

        public int size(){
            return backIndex - frontIndex + 1;
        }

        public boolean isEmpty(){
            if(size()==0){
                return true;
            }else{
                return false;
            }
        }

        public int pop(){
            if(isEmpty()){
                return -1;
            }else{
                return queue[frontIndex++];
            }
        }

        public int front(){
            if(isEmpty()){
                return -1;
            }else{
                return queue[frontIndex];
            }
        }

        public int back(){
            if(isEmpty()){
                return -1;
            }else{
                return queue[backIndex];
            }
        }
    }
}
