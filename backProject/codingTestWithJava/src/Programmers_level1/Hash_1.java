package Programmers_level1;

import java.util.Arrays;

public class Hash_1 {
    public String solution(String[] participant, String[] completion) {
        // 출처:
        // https://programmers.co.kr/learn/courses/30/lessons/42576
        // https://coding-grandpa.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%99%84%EC%A3%BC%ED%95%98%EC%A7%80-%EB%AA%BB%ED%95%9C-%EC%84%A0%EC%88%98-%ED%95%B4%EC%8B%9C-Lv-1

        Arrays.sort(participant);
        Arrays.sort(completion);

        int i = 0;
        for(i=0; i<completion.length; i++){
            if(!participant[i].equals(completion[i])) break;
        }

        return participant[i];
    }
}
