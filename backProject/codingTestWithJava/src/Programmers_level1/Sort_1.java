package Programmers_level1;

import java.util.Arrays;

public class Sort_1 {
    public int[] solution(int[] array, int[][] commands) {
        // 출처:
        // https://programmers.co.kr/learn/courses/30/lessons/42748
        // https://junghn.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-k%EB%B2%88%EC%A7%B8-%EC%88%98-%EC%A0%95%EB%A0%AC

        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] tmp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(tmp);
            answer[i] = tmp[commands[i][2]-1];
        }

        return answer;
    }
}
