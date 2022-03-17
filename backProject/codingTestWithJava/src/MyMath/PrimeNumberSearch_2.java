package MyMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrimeNumberSearch_2{
    public static boolean[] primeList;
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/1929
        // https://st-lab.tistory.com/84

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        primeList = new boolean[N+1];
        primeCheck();

        for(int i=M; i<=N; i++){
            if(!primeList[i]) System.out.println(i);
        }

    }

    static void primeCheck(){
        primeList[0] = primeList[1] = true;
        for(int i=2; i<=Math.sqrt(primeList.length); i++){
            if(primeList[i]) continue;
            for(int j=i*i; j<primeList.length; j+=i){
                primeList[j] = true;
            }
        }
    }
}