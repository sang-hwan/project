package Programmers_level1;

import java.util.ArrayList;

public class BruteForce_1{
    
    public static int[] solution(int[] answers) {
        // 출처:
        // https://programmers.co.kr/learn/courses/30/lessons/42840
        // https://sas-study.tistory.com/240

        // 수포자 패턴
        int[] a = {1, 2, 3, 4, 5}; // 수포자 1번 패턴
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5}; // 2번 패턴
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 3번 패턴

        // 수포자 패턴과 정답 비교
        int[] count = new int[3];
        for(int i=0; i<answers.length; i++){
            if(answers[i]==a[i%a.length]) count[0]++;
            if(answers[i]==b[i%b.length]) count[1]++;
            if(answers[i]==c[i%c.length]) count[2]++;
        }

        // 수포자 간의 정답율 비교
        int max = Math.max(count[0], Math.max(count[1], count[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if(max == count[0]) list.add(1);
        if(max == count[1]) list.add(2);
        if(max == count[2]) list.add(3);

        return list.stream().mapToInt(i->i.intValue()).toArray();
    }
}