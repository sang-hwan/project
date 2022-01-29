package Programmers_level1;

import java.util.Arrays;

public class Greedy_1 {
    public int solution(int n, int[] lost, int[] reserve) {
        // 출처:
        // https://programmers.co.kr/learn/courses/30/lessons/42862
        // https://jeleedev.tistory.com/32

        // 전체 학생 수 n
        // 도난당한 학생 lost[]
        // 여별 있는 학생 reserve[]
        // 수업 들을 수 있는 최대 학생 수 answer
        
        int answer = n-lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i]==reserve[j]){
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i]-1==reserve[j]||lost[i]+1==reserve[j]){
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}
