package MyMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Base_Conversion {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/11576

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); // A 진법
        int B = Integer.parseInt(st.nextToken()); // B 진법
        int m = Integer.parseInt(br.readLine()); // 자릿수 m
        st = new StringTokenizer(br.readLine());
        int n = 0; // A TO 10
        for(int i=0; i<m; i++){
            n += Integer.parseInt(st.nextToken()) * Math.pow(A, m-i-1);
        }
        Stack stk = new Stack();
        while(n>B-1){ // 10 TO B
            stk.push(n%B);
            n /= B;
        }
        stk.push(n);
        while(!stk.isEmpty()){
            System.out.print(stk.pop()+" ");
        }
    }
}
