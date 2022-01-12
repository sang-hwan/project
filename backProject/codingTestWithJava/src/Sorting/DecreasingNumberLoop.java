package Sorting;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class DecreasingNumberLoop {

    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        // 출처: 
        // https://www.acmicpc.net/problem/1174
        // https://coder-in-war.tistory.com/entry/BOJ-JAVA1174-%EC%A4%84%EC%96%B4%EB%93%9C%EB%8A%94-%EC%88%AB%EC%9E%90

        N = Integer.parseInt(br.readLine());
        int[] num = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        ArrayList<Long> arr = new ArrayList<>();

        for(int i=1; i<(1<<10); i++){
            // 2^0 부터 2^10 까지
            long sum = 0;
            for(int j=0; j<10; j++){
                if( (i&(1<<j)) > 0 ){
                    sum = sum * 10 + num[j];
                }
            }
            arr.add(sum);
        }

        Collections.sort(arr);
        if(N>arr.size()){
            bw.write(-1+"\n");
            bw.flush();
            bw.close();
            return;
        }
        bw.write(arr.get(N-1)+"\n");
        bw.flush();
        bw.close();
    }
}
