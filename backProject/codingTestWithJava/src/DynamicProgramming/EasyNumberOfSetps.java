package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EasyNumberOfSetps{
    static Long[][] dp;
    static long MOD = 1_000_000_000;
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/10844
        // https://st-lab.tistory.com/134

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new Long[N+1][10];
        for(int i=0; i<=9; i++){
            dp[1][i] = 1L;
        }
        long result = 0;
        for(int i=1; i<=9; i++){
            result += MyDP(N, i);
        }
        System.out.println(result % MOD);
    }

    static long MyDP(int digit, int val){
        if(digit==1){
            return dp[digit][val];
        }
        if(dp[digit][val]==null){ // 없으면 시간 초과됨
            if(val==0){
                dp[digit][val] = MyDP(digit-1, 1);
            }else if(val==9){
                dp[digit][val] = MyDP(digit-1, 8);
            }else{
                dp[digit][val] = MyDP(digit-1, val-1)+MyDP(digit-1, val+1);
            }
        }
        return dp[digit][val] % MOD;
    }
}