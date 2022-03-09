package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FourNumbers {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/10824

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long answer = Long.parseLong(input[0]+input[1]) + Long.parseLong(input[2]+input[3]);
        System.out.println(answer);
    }
}
