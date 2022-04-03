package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DateCalculation {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/1476

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer_E = Integer.parseInt(st.nextToken()); // 1 ≤ E ≤ 15
        int answer_S = Integer.parseInt(st.nextToken()); // 1 ≤ S ≤ 28
        int answer_M = Integer.parseInt(st.nextToken()); // 1 ≤ M ≤ 19
        int E = 0, S = 0, M = 0, year =0;
        while(answer_E!=E||answer_S!=S||answer_M!=M){
            E++;
            S++;
            M++;
            year++;
            if(E>15) E = 1;
            if(S>28) S = 1;
            if(M>19) M = 1;
        }
        System.out.println(year);
    }
}
