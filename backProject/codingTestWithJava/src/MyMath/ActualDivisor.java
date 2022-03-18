package MyMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ActualDivisor {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/2247
        // https://kbw1101.tistory.com/32
        // https://github.com/ds-ai96/Algorithm/blob/main/Backjoon/2247%20%EC%8B%A4%EC%A7%88%EC%A0%81%20%EC%95%BD%EC%88%98%20(G4).py

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());
        long csod = 0;
        for(long i=2; i<n/2+1; i++){
            csod += ((n/i)-1)*i;
            System.out.println("i: "+i+", csod: "+csod);
        }
        System.out.println(csod%1000000);

        // 시간초과
        // int sum = 0;
        // for(int i=2; i<=n; i++){
        //     for(int j=2; j<=Math.sqrt(i); j++){
        //         if(i==j) continue;
        //         if(i%j==0){
        //             if(j!=i/j){
        //                 sum += j+i/j;
        //             }else{
        //                 sum += j;
        //             }
        //         }
        //     }
        // }
        // System.out.println(sum%1000000);
    }
}
