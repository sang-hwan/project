import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GreatestCommonFactor_limit {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        // 출처: https://www.acmicpc.net/problem/1850
        // 최대공약수 문제
        // A, B의 모든 자리는 1로만 이루어진다 | 예) A = 111, B = 111111
        // 두 수의 최대공약수를 구해라
        // 첫 줄. 즉, 입력은 A와 B를 이루는 1의 개수 | 예) 3 4
        // 입력하는 자연수는 2^63 보다 작은 자연수
        // A와 B의 최대공약수를 출력한다
        // 출력하는 자연수는 천만 자리수를 넘으면 안된다

        StringTokenizer st = new StringTokenizer(br.readLine());
        String stringA = "";
        String stringB = "";
        int inputA = Integer.parseInt(st.nextToken());
        int inputB = Integer.parseInt(st.nextToken());
        for(int i=0; i<inputA; i++){
            stringA = stringA + 1;
        }
        for(int i=0; i<inputB; i++){
            stringB = stringB + 1;
        }
        int A = Integer.parseInt(stringA);
        int B = Integer.parseInt(stringB);

        int countA = 0;
        int countB = 0;
        int indexA = 0;
        int indexB = 0;

        // A 약수 구하기
        int[] arrA1 = new int[A+1];
        for(int i=1; i<=A; i++){
            if(A%i==0){
                arrA1[i] = i;
            }
        }
        // arrA1 0 없애기
        for(int i=0; i<=A; i++){
            if(arrA1[i]==0){
                continue;
            }else{
                countA++;
            }
        }
        // A 약수 rebuilding
        int[] arrA2 = new int[countA];
        for(int i=1; i<=A; i++){
            if(arrA1[i]==0){
                continue;
            }else{
                arrA2[indexA] = arrA1[i];
                indexA++;
            }
        }

        // B 약수 구하기
        int[] arrB1 = new int[B+1];
        for(int i=1; i<=B; i++){
            if(B%i==0){
                arrB1[i] = i;
            }
        }
        // arrB1 0 없애기
        for(int i=0; i<=B; i++){
            if(arrB1[i]==0){
                continue;
            }else{
                countB++;
            }
        }
        // B 약수 rebuilding
        int[] arrB2 = new int[countB];
        for(int i=1; i<=B; i++){
            if(arrB1[i]==0){
                continue;
            }else{
                arrB2[indexB] = arrB1[i];
                indexB++;
            }
        }

        int[] arrAnB = new int[Math.max(arrA2.length, arrB2.length)];
        int countAnB = 0;
        // A 약수 arrA2, B 약수 arrB2 의 공약수 arrAnB
        for(int i=0; i<arrA2.length; i++){
            for(int j=0; j<arrB2.length; j++){
                if(arrA2[i]==arrB2[j]){
                    arrAnB[countAnB] = arrA2[i];
                }else{
                    continue;
                }
            }
        }

        // 최대공약수
        Arrays.sort(arrAnB);
        int K = arrAnB[arrAnB.length-1];
        bw.write(K + "\n");
        bw.flush();
        bw.close();
    }
}
