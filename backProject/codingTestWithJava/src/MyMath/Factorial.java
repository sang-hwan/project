package MyMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/10872

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long answer = 1;
        while(N!=0){
            answer *= N;
            N--;
        }
        System.out.println(answer);
    }
}
