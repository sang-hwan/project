package Stack;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Zero2 {
    public static void main(String[] args) throws IOException{
        // 출처: https://www.acmicpc.net/problem/10773
        // 제로 문제

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());
        int[] arr = new int[K];
        int input = 0;
        int index = 0;
        for(int item: arr){
            input = Integer.parseInt(br.readLine());

            if(input!=0){
                arr[index] = input;
                index++;
            }else{
                arr[index-1] = 0;
                index--;
            }
        }

        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
        }


        bw.write(sum+"\n");
        bw.flush();
        bw.close();
    }
}
