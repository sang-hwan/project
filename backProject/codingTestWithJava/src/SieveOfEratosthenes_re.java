import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SieveOfEratosthenes_re {
    public static void main(String[] args) throws IOException{
        // 런타임 에러납니다. 나중에 10문제 풀고 질문 게시판에 올려보세요.
        // 에라토스테네스의 체 문제
        // 1. 2부터 N까지 모든 정수를 적는다.
        // 2. 아직 지우지 않은 수 중 가장 작은 수를 찾는다. 이것을 P라고 하고, 이 수는 소수이다.
        // 3. P를 지우고, 아직 지우지 않은 P의 배수를 크기 순서대로 지운다.
        // 4. 아직 모든 수를 지우지 않았다면, 다시 2번 단계로 간다.
        // N, K가 주어졌을 때, K번째 지우는 수를 구하라

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int count = 0;

        boolean[] arr = new boolean[N+1];
        for(int i=2; i<=N; i++){
            if(count==K){
                break;
            }else{
                for(int j=i; j<=N; j+=i){
                    if(!arr[j]){
                        arr[j] = true;
                        count++;
                    }
                    if(count==K){
                        bw.write(j + "\n");
                        break;
                    }
                }
            }
        }
        bw.flush();
        bw.close();
    }
}