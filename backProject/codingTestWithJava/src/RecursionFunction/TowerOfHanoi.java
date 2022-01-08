package RecursionFunction;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class TowerOfHanoi{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/1914
        // https://www.youtube.com/watch?v=FYCGV6F1NuY&ab_channel=%ED%8C%8C%EC%9D%B4%EC%8D%AC%ED%81%B4%EB%9E%98%EC%8A%A4
        // https://www.youtube.com/watch?v=uSSC0aKXbWQ&ab_channel=%EB%94%A9%EC%BD%94%EB%94%A9
        // https://simsimjae.tistory.com/223
        // https://chanchan-father.tistory.com/418

        // 하노이 탑 문제
        // 첫째 줄에 첫 번째 장대에 쌓인 원판의 개수 N(1<=N<=100)
        // 첫째 줄 출력 K는 최소 옮긴 횟수
        // N이 20 이하이면 수행 과정을 출력하고, 아니면 하지 않는다
        // 수행 과정은 A + " " + B로 표기한다
        // A 에는 옮기려는 원판이 있는 장대를 표기
        // B 에는 옮긴 원판을 놔둘 장대를 표기
        
        int N = Integer.parseInt(br.readLine());
        BigInteger bi = new BigInteger("2");
        BigInteger K = bi.pow(N).subtract(BigInteger.ONE);
        bw.write(K+"\n");

        if(N<=20){
            hanoi(N, 1, 3, 2);
        }

        bw.flush();
        bw.close();
    }

    public static void hanoi(int n, int start, int end, int mid) throws IOException{
        // n: 원판의 개수, start: 시작 장판 번호, end: 도착 장판 번호, mid: n-1개의 원판을 둘 장판
        if(n==1){
            bw.write(start+" "+end+"\n");
            return;
        }

        // n개의 원판을 end로 옮기는 과정
        // 1. n-1개의 원판을 mid로 옮긴다
        hanoi(n-1, start, mid, end);

        // 2. n을 end로 옮긴다
        bw.write(start+" "+end+"\n");

        // 3. n-1을 end로 옮긴다
        hanoi(n-1, mid, end, start);

        return;
    }
}