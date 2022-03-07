package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class NGF {
    public static void main(String[] args) throws IOException{
        // 출처: 
        // https://www.acmicpc.net/problem/17299
        // https://binghedev.tistory.com/49

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); // 배열 크기 N

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N]; // 배열 A
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] A_count = new int[1000001]; // 배열 A 원소의 등장 횟수
        for(int i=0; i<N; i++){
            A_count[A[i]] += 1;
        }

        Stack<Integer> stk = new Stack<>();
        for(int i=0; i<N; i++){
            while(!stk.isEmpty()&&A_count[A[stk.peek()]]<A_count[A[i]]){
                A[stk.pop()] = A[i];
            }
            stk.push(i);
        }
        while(!stk.isEmpty()){
            A[stk.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(A[i]+" ");
        }
        System.out.println(sb);
    }
}
