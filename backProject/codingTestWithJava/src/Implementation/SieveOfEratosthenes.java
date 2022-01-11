package Implementation;
import java.util.Scanner;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        // 에라토스테네스의 체 문제
        // 1. 2부터 N까지 모든 정수를 적는다.
        // 2. 아직 지우지 않은 수 중 가장 작은 수를 찾는다. 이것을 P라고 하고, 이 수는 소수이다.
        // 3. P를 지우고, 아직 지우지 않은 P의 배수를 크기 순서대로 지운다.
        // 4. 아직 모든 수를 지우지 않았다면, 다시 2번 단계로 간다.
        // N, K가 주어졌을 때, K번째 지우는 수를 구하라

        // 출처:
        // https://www.acmicpc.net/problem/2960
        // https://velog.io/@juhyun7793/%EB%B0%B1%EC%A4%80-2960-%EC%97%90%EB%9D%BC%ED%86%A0%EC%8A%A4%ED%85%8C%EB%84%A4%EC%8A%A4%EC%9D%98-%EC%B2%B4-Java

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        boolean[] primeNum = new boolean[N+1];
        
        int count = 0;
        
        // 2부터 N까지 true로 이루어진 배열
        for(int i=2; i<=N; i++){
            primeNum[i] = true;
        }

        // 2부터 true를 false로 변환 → 2부터 숫자를 지워나간다
        // false로 변환이 될때마다 count++
        // 이미 false로 변환된 숫자를 마주하면 continue를 통해 count가 추가되지 않는다
        for(int i=2; i<=N; i++){
            for(int j=i; j<=N; j+=i){
                if(!primeNum[j]){
                    continue;
                }else{
                    primeNum[j] = false;
                    count++;
                }
                if(count==K){
                    System.out.println(j);
                    System.exit(0);
                }
            }
        }

    }
}
