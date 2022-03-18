package MyMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberOfZerosInCombination {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/2004
        // https://st-lab.tistory.com/166

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long count_five = five_power(n)-five_power(m)-five_power(n-m);
        long count_two = two_power(n)-two_power(m)-two_power(n-m);

        System.out.println(Math.min(count_five, count_two));
    }

    static long two_power(long num){
        int count = 0;
        while(num>=2){
            count += num/2;
            num /= 2;
        }
        return count;
    }

    static long five_power(long num){
        int count = 0;
        while(num>=5){
            count += num/5;
            num /= 5;
        }
        return count;
    }
}
