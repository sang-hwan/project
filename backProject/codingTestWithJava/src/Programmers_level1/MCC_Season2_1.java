package Programmers_level1;

public class MCC_Season2_1{

    public int solution(int[] absolutes, boolean[] signs) {
        // 출처: https://programmers.co.kr/learn/courses/30/lessons/76501

        int answer = 0;
        for(int i=0; i<absolutes.length; i++){
            if(!signs[i]) absolutes[i] -= 2*absolutes[i];
            // answer += absolutes[i] * (signs[i] ? 1:-1);
            answer += absolutes[i];
        }

        return answer;
    }
}