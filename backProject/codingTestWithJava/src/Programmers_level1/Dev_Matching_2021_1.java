package Programmers_level1;

import java.util.ArrayList;
import java.util.TreeSet;

public class Dev_Matching_2021_1 {
    // 출처:
    // https://programmers.co.kr/learn/courses/30/lessons/77484

    public int[] solution(int[] lottos, int[] win_nums) {
        // lottos 의 원소와 win_nums 의 원소를 비교하여 일치하는 개수 count_1
        ArrayList<Integer> lottosList = new ArrayList<>();
        for(int i=0; i<lottos.length; i++){
            lottosList.add(lottos[i]);
        }
        int count_1 = 0;
        for(int win_num : win_nums){
            if(lottosList.contains(win_num)){
                count_1++;
            }
        }

        // lottos 에서 0 인 원소의 개수 count_2
        int count_2 = 0;
        TreeSet<Integer> lottos_set = new TreeSet<>();
        for(int lotto : lottos){
            lottos_set.add(lotto);
        }
        ArrayList<Integer> lottos_set_to_list = new ArrayList<>(lottos_set);
        if(lottos_set_to_list.get(0) == 0){
            count_2 = lottos.length - lottos_set_to_list.size() + 1;
        }

        // count 에 따른 로또 순위 (최대, 최소)
        int[] answer = new int[2];
        int answerMax = count_1+count_2;
        if(answerMax==6){
            answer[0] = 1;
        }else if(answerMax==5){
            answer[0] = 2;
        }else if(answerMax==4){
            answer[0] = 3;
        }else if(answerMax==3){
            answer[0] = 4;
        }else if(answerMax==2){
            answer[0] = 5;
        }else{
            answer[0] = 6;
        }

        if(count_1==6){
            answer[1] = 1;
        }else if(count_1==5){
            answer[1] = 2;
        }else if(count_1==4){
            answer[1] = 3;
        }else if(count_1==3){
            answer[1] = 4;
        }else if(count_1==2){
            answer[1] = 5;
        }else{
            answer[1] = 6;
        }
        
        return answer;
    }
}