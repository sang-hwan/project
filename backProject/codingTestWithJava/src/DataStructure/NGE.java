package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class NGE {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/17298
        // https://st-lab.tistory.com/196

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 배열 A의 크기 N
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N]; // 배열 A
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stk = new Stack<>();
        for(int i=0; i<N; i++){
            while(!stk.isEmpty()&&A[stk.peek()]<A[i]){
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
        
        // 시간초과
        // for(int i=0; i<N; i++){
        //     for(int j=i; j<N; j++){
        //         if(A[i]<A[j]){
        //             sb.append(A[j]+" ");
        //             break;
        //         }
        //         if(j==N-1) sb.append(-1+" ");
        //     }
        // }
    }
}
