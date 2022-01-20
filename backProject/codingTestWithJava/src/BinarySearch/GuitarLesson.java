package BinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class GuitarLesson {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, total, elMax;
    static int arrN[];

    public static void main(String[] args) throws IOException{
        // 출처: 
        // https://www.acmicpc.net/problem/2343

        // 입력 첫째줄
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 각 강의 시간 배열
        arrN = new int[N];

        // 입력 둘째줄
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<arrN.length; i++){
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        // 총 강의 시간
        for(int i=0; i<arrN.length; i++){
            total += arrN[i];
            elMax = Math.max(arrN[i], elMax);
        }

        // 탐색
        int start = elMax;
        int end = total;
        while(start<=end){
            int tmp = 0;
            int count = 0;
            int mid = (start+end)/2;
            for(int i=0; i<arrN.length; i++){
                tmp += arrN[i];
                if(tmp>mid){
                    tmp = 0;
                    count++;
                    i--;
                }
            }
            count++;
            if(count<=M){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        bw.write(Integer.toString(start));
        bw.flush();
        bw.close();

    }
}
