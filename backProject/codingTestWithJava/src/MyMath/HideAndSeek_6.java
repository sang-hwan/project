package MyMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HideAndSeek_6{
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/17087

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[Integer.parseInt(st.nextToken())];
        int S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++){
            arr[i] = Math.abs(S - Integer.parseInt(st.nextToken()));
        }
        int min = Integer.MAX_VALUE;
        if(arr.length>1){
            for(int i=0; i<arr.length-1; i++){
                min = Math.min(min, MyGCD(arr[i], arr[i+1]));
            }
        }else{
            min = arr[0];
        }

        System.out.println(min);
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