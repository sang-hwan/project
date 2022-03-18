package MyMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOfZerosInFactorial{
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/1676
        // https://st-lab.tistory.com/165

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        while(N>=5){
            count += N/5;
            N /= 5;
        }
        System.out.println(count);
    }
}