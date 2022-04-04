package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberContinuation{
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/1748

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i=1; i<=N; i++){ // 100_000_000
            if(i<10){
                count += 1;
            }else if(10<=i&&i<100){
                count += 2;
            }else if(100<=i&&i<1_000){
                count += 3;
            }else if(1_000<=i&&i<10_000){
                count += 4;
            }else if(10_000<=i&&i<100_000){
                count += 5;
            }else if(100_000<=i&&i<1_000_000){
                count += 6;
            }else if(1_000_000<=i&&i<10_000_000){
                count += 7;
            }else if(10_000_000<=i&&i<100_000_000){
                count += 8;
            }else{
                count += 9;
            }
        }
        System.out.println(count);
    }
}