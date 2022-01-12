package Sorting;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class DecreasingNumberRF{

    static ArrayList<Long> arr = new ArrayList<>();
    static int[] num = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        // 출처: 
        // https://www.acmicpc.net/problem/1174
        // https://coder-in-war.tistory.com/entry/BOJ-JAVA1174-%EC%A4%84%EC%96%B4%EB%93%9C%EB%8A%94-%EC%88%AB%EC%9E%90
        int N = Integer.parseInt(br.readLine());
        descNum(0, 0);
        Collections.sort(arr);
        if(N>1023){
            bw.write(-1+"\n");
        }else{
            bw.write(arr.get(N-1)+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static void descNum(long sum, int idx){
        if(!arr.contains(sum)) arr.add(sum);
        if(idx>=10) return;
        descNum( (sum*10)+num[idx], idx+1 );
        descNum(sum, idx+1);
    }
}