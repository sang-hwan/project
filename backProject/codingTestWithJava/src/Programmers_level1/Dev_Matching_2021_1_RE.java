package Programmers_level1;

public class Dev_Matching_2021_1_RE {
    // 출처:
    // https://programmers.co.kr/learn/courses/30/lessons/77484
    // https://taehoung0102.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4Java-Level1-%EB%A1%9C%EB%98%90%EC%9D%98-%EC%B5%9C%EA%B3%A0-%EC%88%9C%EC%9C%84%EC%99%80-%EC%B5%9C%EC%A0%80-%EC%88%9C

    public int[] solution(int[] lottos, int[] win_nums) {
        
        int[] answer = new int[2];

        int correct = 0;
        int zero = 0;
        int[] rank = {6, 6, 5, 4, 3, 2, 1};

        for(int i=0; i<lottos.length; i++){
            for(int j=0; j<win_nums.length; j++){
                if(lottos[i]==0){
                    zero++;
                    break;
                }
                if(lottos[i]==win_nums[j]){
                    correct++;
                    break;
                }
            }
        }

        answer[0] = rank[zero+correct];
        answer[1] = rank[correct];

        return answer;
    }
}