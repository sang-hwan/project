package Greedy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM_re {
    public static void main(String[] args) throws IOException{
        // 출처: https://www.acmicpc.net/problem/11399
        // 런타임 에러납니다. 나중에 10문제 풀고 질문 게시판에 올려보세요.
        // N 한 줄, P 한 줄 넣어야 되는데 P를 원소마다 한 줄씩 입력했기에 런타임 에러가 났습니다.
        // ATM 문제
        // ATM은 오직 한 대
        // 사람의 수는 N(1<=N<=1,000)
        // 각 사람이 돈을 인출하는데 걸리는 시간P_i(1<=P_i<=1,000)
        // 시간의 합의 최솟값 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];

        // for(int i=0; i<N; i++){
        //     P[i] = Integer.parseInt(br.readLine());
        // } // P를 한 줄씩 입력하기에 런타임 에러가 났습니다.

        // int P_index= 0;
        // for (String numberString : br.readLine().split(" ")){
        //     P[P_index++] = Integer.parseInt(numberString);
        // } // baekjoon 질문에 대한 답변 코드

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            P[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(P);

        int privateDelay = 0;
        int totalDelay = 0;

        for(int i=0; i<N; i++){
            totalDelay += privateDelay + P[i];
            privateDelay += P[i];
        }

        bw.write(totalDelay + "\n");
        bw.flush();
        bw.close();
    }
}
