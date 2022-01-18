package BinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class GameBS {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static long X, Y, Z;

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://herong.tistory.com/entry/BOJ-1072-%EA%B2%8C%EC%9E%84-Java
        // https://www.acmicpc.net/problem/1072

        st = new StringTokenizer(br.readLine());
        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());
        Z = Y*100/X;
        if(Z>=99){
            bw.write(Integer.toString(-1));
        }else{
            BinarySearch(1, X);
        }
        bw.flush();
        bw.close();
    }

    public static void BinarySearch(long start, long end) throws IOException{
        long mid = 0, primeZ = 0;
        while(start<=end){
            mid = (start+end)/2;
            primeZ = (Y+mid)*100/(X+mid);
            if(primeZ>Z){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        bw.write(Long.toString(start));
    }
}
