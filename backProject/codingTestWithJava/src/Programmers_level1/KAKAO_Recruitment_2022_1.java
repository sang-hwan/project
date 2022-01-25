package Programmers_level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KAKAO_Recruitment_2022_1 {
    // 출처: 
    // https://programmers.co.kr/learn/courses/30/lessons/92334
    // https://velog.io/@ujone/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%8B%A0%EA%B3%A0-%EA%B2%B0%EA%B3%BC-%EB%B0%9B%EA%B8%B0-JAVA

    public int[] solution(String[] id_list, String[] report, int k){
        int[] answer = new int[id_list.length];
        Map<String, Integer> index = new HashMap<>();
        Map<String, List<Integer>> list = new HashMap<>();

        for(int i=0; i<id_list.length; i++){
            index.put(id_list[i], i);
        }

        for(String rep : report){
            String[] ids = rep.split(" ");
            String fromId = ids[0], toId = ids[1];
            if(!list.containsKey(toId)) list.put(toId, new ArrayList<>());
            List<Integer> tmp = list.get(toId);
            if(!tmp.contains(index.get(fromId))) tmp.add(index.get(fromId));
        }

        for(int i=0; i<id_list.length; i++){
            String id = id_list[i];
            if(list.containsKey(id) && list.get(id).size()>=k){
                for(int idx:list.get(id)){
                    answer[idx]++;
                }
            }
        }

        return answer;
    }
        
}
