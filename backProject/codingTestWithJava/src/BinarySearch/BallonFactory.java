package BinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BallonFactory{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int arrA[];

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/15810
        // https://velog.io/@kjihye0340/%EB%B0%B1%EC%A4%80-15810-%ED%92%8D%EC%84%A0-%EA%B3%B5%EC%9E%A5
        
        // N 명의 스태프, M 개의 풍선
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // N 명의 스태프 각각의 풍선을 만드는 시간
        arrA = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<arrA.length; i++){
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        // 이진 탐색
        Arrays.sort(arrA);
        long mid = 0;
        long start = 0;
        long end = arrA[0]*M;

        while(start<=end){
            long total = 0;
            mid = (start+end)/2;
            for(int i=0; i<arrA.length; i++){
                total += mid/arrA[i];
            }
            if(total>=M){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        bw.write(Long.toString(start));
        bw.flush();
        bw.close();
    }
}