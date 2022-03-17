package MyMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GCM {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/1934

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(Mygcm(a, b)+"\n");
        }

        System.out.println(sb);
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
