package RecursionFunction;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class GCD {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/1850
        // https://pangsblog.tistory.com/61
        // https://soojong.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98%EC%9E%90%EB%B0%94-%EB%B0%B1%EC%A4%80-1850%EB%B2%88-%EC%B5%9C%EB%8C%80%EA%B3%B5%EC%95%BD%EC%88%98
        // 최대공약수 문제

        // 1. 반복문
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        
        long gcd = getGCD(Math.max(A, B), Math.min(A, B));
        
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=gcd; i++) sb.append("1");
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        
        // 2. 재귀함수
        // StringTokenizer st = new StringTokenizer(br.readLine());
        // long A = Long.parseLong(st.nextToken());
        // long B = Long.parseLong(st.nextToken());
        
        // long repeat = getGCD(A, B);
        
        // String gcd = "1".repeat((int)repeat);
        
        // bw.write(gcd + "\n");
        // bw.flush();
        // bw.close();
    }

    // 반복문 getGCD
    public static long getGCD(long a, long b){
        while(b>0){
            long tmp = a;
            a = b;
            b = tmp%b;
        }
        return a;
    }

    // 재귀함수 getGCD
    // public static long getGCD(long a, long b){
    //     if(b==0){
    //         return a;
    //     }else{
    //         long r = a%b;
    //         return getGCD(b, r);
    //     }
    // }
}
