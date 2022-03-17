package MyMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Remainder {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/10430

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        int answer1 = (A+B)%C;
        int answer2 = ((A%C) + (B%C))%C;
        int answer3 = (A*B)%C;
        int answer4 = ((A%C) * (B%C))%C;

        System.out.println(answer1);
        System.out.println(answer2);
        System.out.println(answer3);
        System.out.println(answer4);
    }
}
