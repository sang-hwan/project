package MyMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GCDnGCM {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/2609
        // https://st-lab.tistory.com/154

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(Mygcd(a, b));
        System.out.println(Mygcm(a, b));
    }

    static int Mygcd(int a, int b){
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

    static int Mygcm(int a, int b){
        return a * b / Mygcd(a, b);
    }
}
