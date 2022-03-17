package MyMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrimeNumberSearch{
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/1978

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] check = new boolean[1001]; // 소수면 true 아니면 false
        for(int i=1; i<=1000; i++){
            check[i] = primeCheck(i);
        }

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int input = 0;
        int count = 0;
        for(int i=1; i<=N; i++){
            input = Integer.parseInt(st.nextToken());
            if(check[input]) count++;
        }
        System.out.println(count);
    }

    static boolean primeCheck(int n){
        if(n==1){
            return false;
        }else if(n==2){
            return true;
        }else{
            for(int i=2; i<n; i++){
                if(n%i==0) return false;
            }
        }

        return true;
    }
}