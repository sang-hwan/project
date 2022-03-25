package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PinaryNumber {
    static Long[][] dp;
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/2193

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new Long[N+1][2];
        dp[1][0] = dp[1][1] = 1L;
        long result = MyDP(N, 1);
        System.out.println(result);
    }

    static long MyDP(int digit, int val){
        if(digit==1){
            return dp[digit][val];
        }
        if(dp[digit][val]==null){ // 없으면 시간 초과됨
            if(val==0){
                dp[digit][val] = MyDP(digit-1, 1) + MyDP(digit-1, 0);
            }else{
                dp[digit][val] = MyDP(digit-1, 0);
            }
        }

        return dp[digit][val];
    }
}
