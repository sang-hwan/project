package BinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class NumberCard_TimeOver{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int arrN[], arrM[];
    static boolean check[];

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

        for(int i=0; i<M; i++){
            check = new boolean[N];
            for(int j=0; j<N; j++){
                if(arrM[i]==arrN[j]){
                    check[j] = true;
                }
            }
            for(int k=0; k<N; k++){
                if(check[k]){
                    sb.append(1+" ");
                    break;
                }
                if(k==N-1&&!check[N-1]){
                    sb.append(0+" ");
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}