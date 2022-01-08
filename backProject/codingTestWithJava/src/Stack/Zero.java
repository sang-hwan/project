package Stack;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Zero {
    public static void main(String[] args) throws IOException{
        // 출처: https://www.acmicpc.net/problem/10773
        // 제로 문제

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<K; i++){
            int input = Integer.parseInt(br.readLine());
            if(input!=0){
                stack.push(input);
            }else{
                stack.pop();
            }
        }

        int sum = 0;
        for(int i=0; i<stack.size(); i++){
            sum += stack.get(i);
        }

        bw.write(sum+"\n");
        bw.flush();
        bw.close();
    }
}
