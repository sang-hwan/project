package Programmers_level1;

public class MCC_Season1_1 {
    public int solution(int[] a, int[] b) {
        // 출처: https://programmers.co.kr/learn/courses/30/lessons/70128

        int answer = 0;
        for(int i=0; i<a.length; i++){
            answer += a[i]*b[i];
        }
        return answer;
    }
}
