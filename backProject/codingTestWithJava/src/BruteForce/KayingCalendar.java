package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KayingCalendar {

    static int T, M, N, x, y, answer, index;
    static long maxRange;

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/6064
        // https://deveric.tistory.com/44

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            answer = index = 0;
            maxRange = M*N;
            if(y==N) y=0;
            while(true){
                if((M*index+x)%N == y){
                    answer = M*index+x;
                    break;
                }
                if(M*index+x > maxRange){
                    answer = -1;
                    break;
                }
                index++;
            }
            System.out.println(answer);
        }
    }
}
