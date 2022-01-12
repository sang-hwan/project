package BruteForce;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Resignation_re {
    public static void main(String[] args) throws IOException{
        // 출처: https://www.acmicpc.net/problem/14501
        // 퇴사 문제
        // N+1일째 퇴사
        // 날마다 업무 기간 T_i와 금액 P_i 를 정한다
        // 최대 수익을 구하라

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N+2];
        int[] P = new int[N+2];
        int[] sum = new int[N+2];
        
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=N; i>0; i--){
            int next = i + T[i];
            if(next>N+1){
                sum[i] = sum[i+1]; // i 日은 반영이 불가하므로 i+1 日의 sum이 최대값
            }else{
                sum[i] = Math.max(sum[i+1], sum[next]+P[i]);
                // (i+1 日의 sum) vs (i 日에 일한 금액 + i 日에 배정된 시간 T[i] 이후 next 日의 sum) 중 더 큰 값이 최대값
            }
        }

        bw.write(sum[1] + "\n");
        bw.flush();
        bw.close();

    }
}
