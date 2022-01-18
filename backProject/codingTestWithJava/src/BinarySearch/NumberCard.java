package BinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCard {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int arrN[], arrM[];

    public static void main(String[] args) throws IOException{
        // 출처: https://www.acmicpc.net/problem/10815
        
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arrN = new int[N];
        for(int i=0; i<N; i++){
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arrM = new int[M];
        for(int i=0; i<M; i++){
            arrM[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrN);

        for(int i=0; i<M; i++){
            bs(arrM[i]);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void bs(int target){
        int left = 0;
        int right = N-1;
        int nowMid = (left+right)/2;
        int preMid = 0;

        while(nowMid!=preMid){
            if(arrN[nowMid]>target){
                preMid = nowMid;
                right = nowMid-1;
                nowMid = (left+right)/2;
            }else if(arrN[nowMid]<target){
                preMid = nowMid;
                left = nowMid+1;
                nowMid = (left+right)/2;
            }else if(arrN[nowMid]==target){
                sb.append(1+" ");
                break;
            }
        }
        
        if(arrN[nowMid]!=target){
            sb.append(0+" ");
        }
    }
}
