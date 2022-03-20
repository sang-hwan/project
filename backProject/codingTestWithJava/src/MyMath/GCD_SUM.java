package MyMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GCD_SUM{
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/9613

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for(int j=0; j<n; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            long sum = 0;
            for(int j=0; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    sum += MyGCD(arr[j], arr[k]);
                }
            }
            sb.append(sum+"\n");
        }
        System.out.println(sb);
    }

    static int MyGCD(int a, int b){
        if(a>b){
            while(b!=0){
                int r = a % b;
                a = b;
                b = r;
            }
            return a;
        }else{
            while(a!=0){
                int r = b % a;
                b = a;
                a = r;
            }
            return b;
        }
    }
}