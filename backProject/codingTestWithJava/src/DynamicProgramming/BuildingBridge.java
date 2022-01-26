package DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BuildingBridge{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static double T, N, M, num1, num2, answer;

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/1010
        // https://cow-kite24.tistory.com/67

        // 테스트 케이스 T
        T = Integer.parseInt(br.readLine());

        // 다리 놓는 경우의 수
        for(int i=0; i<T; i++){
            // N, M 입력
            st = new StringTokenizer(br.readLine());
            N = Double.parseDouble(st.nextToken());
            M = Double.parseDouble(st.nextToken());

            // 분자 num1
            num1 = 1;
            for(double j=M-N+1; j<=M; j++){
                num1 *= j;
            }
            
            // 분모 num2
            num2 = 1;
            for(double k=1; k<=N; k++){
                num2 *= k;
            }

            // mCn: 조합
            answer = num1 / num2;
            String sFormat = String.format("%.0f\n", answer);
            bw.write(sFormat);
        }
        bw.flush();
        bw.close();
    }
    
}
