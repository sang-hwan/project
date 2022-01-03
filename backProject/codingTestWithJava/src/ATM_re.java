import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ATM_re {
    public static void main(String[] args) throws IOException{
        // 런타임 에러납니다. 나중에 10문제 풀고 질문 게시판에 올려보세요.
        // 답변 받았습니다. → bufferedReader가 한 줄로 받기때문에 split으로 구분을 해주고 하나씩 입력하는 형태로 만들어줘야 한다고 합니다.
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
        // } // java 11에서 이렇게 하면 입력한 값 3 1 2 3 4 가 한글자씩이 아니라 한 줄로 인식이 되기에 split으로 나눠줘야 한다고 합니다.

        int P_index= 0;
        for ( String numberString : br.readLine().split(" ") ){
            P[P_index++] = Integer.parseInt(numberString);
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
