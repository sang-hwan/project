package MyMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorization {
    static boolean[] primeList;
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/11653

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        primeList = new boolean[10000001];
        primeCheck();

        int N = Integer.parseInt(br.readLine());
        while(N>1){
            for(int i=2; i<=N; i++){
                if(!primeList[i] && N%i==0){
                    System.out.println(i);
                    N /= i;
                    break;
                }
            }
        }
    }

    static void primeCheck(){
        primeList[0] = primeList[1] = true;
        for(int i=2; i<Math.sqrt(primeList.length); i++){
            if(primeList[i]) continue;
            for(int j=i*i; j<primeList.length; j+=i){
                primeList[j] = true;
            }
        }
    }
}
