package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostfixNotation_2{
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/1935
        // https://codeung.tistory.com/271

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String prefix = br.readLine();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stk = new Stack<>();
        int len = prefix.length();
        for(int i=0; i<len; i++){
            char chr = prefix.charAt(i);
            if('A'<=chr&&chr<='Z'){
                double d = arr[chr-'A'];
                stk.push(d);
            }else{
                double d1 = stk.pop();
                double d2 = stk.pop();
                double d3 = 0.0;
                switch(chr){
                    case'+':
                        d3=d2+d1;
                        break;
                    case'-':
                        d3=d2-d1;
                        break;
                    case'*':
                        d3=d2*d1;
                        break;
                    case'/':
                        d3=d2/d1;
                        break;
                }
            stk.push(d3);
            }
        }

        System.out.printf("%.2f", stk.pop());

    }
}