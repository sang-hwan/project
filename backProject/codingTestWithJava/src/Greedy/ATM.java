package Greedy;
// import java.util.Arrays;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) throws Exception {
        // ATM 문제
        // ATM은 오직 한 대
        // 사람의 수는 N(1<=N<=1,000)
        // 각 사람이 돈을 인출하는데 걸리는 시간P_i(1<=P_i<=1,000)
        // 시간의 합의 최솟값 출력

        // 출처:
        // https://www.acmicpc.net/problem/11399
        // https://st-lab.tistory.com/147

        // 풀이 1. [Scanner + Arrays.sort()]

        // Scanner sc = new Scanner(System.in);

        // int N = sc.nextInt();

        // int[] arr = new int[N];

        // for(int i=0; i<N; i++){
        //     arr[i] = sc.nextInt();
        // }

        // // 정렬
        // Arrays.sort(arr);

        // int prev = 0; // 이전까지의 대기시간 누적합
        // int sum = 0; // 사람별 대기시간 총합

        // for(int i = 0; i < N; i++){
        //     // 이전까지의 대기시간과 현재 사람이 걸리는 시간을 더해준다.
        //     sum += prev + arr[i];

        //     // 이전까지의 누적합에 현재 걸리는 시간을 더해준다.
        //     prev += arr[i];
        // }

        // System.out.println(sum);

        // 풀이 2. [Scanner + Counting Sort]

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        // 입력의 범위는 1~1,000이므로 1001개의 index를 둔다.
        int[] arr = new int[1001];
        
        // Counting Sort
        while(N-- > 0){
            arr[sc.nextInt()]++;
        }

        int prev = 0; // 이전까지의 대기시간 누적합
        int sum = 0; // 사람별 대기시간 총합

        for(int i=0; i<1001; i++){
            // 해당 i index가 0이 될 때 까지 반본
            while(arr[i]-- > 0){
                // 이전까지의 대기시간과 현재 사람이 걸리는 시간을 더해준다.
                sum += (i+prev);

                // 이전까지의 누적합에 현재 걸리는 시간을 더해준다.
                prev += i;
            }
        }

        System.out.println(sum);
    }
}
