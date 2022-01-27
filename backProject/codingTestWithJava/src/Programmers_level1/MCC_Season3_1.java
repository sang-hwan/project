package Programmers_level1;

public class MCC_Season3_1{

    public static int solution(int[] numbers) {
        // 출처: https://programmers.co.kr/learn/courses/30/lessons/86051

        boolean[] check = new boolean[10];
        for(int i=0; i<numbers.length; i++){
            check[numbers[i]] = true;
        }
        
        int answer = 0;
        for(int i=0; i<check.length; i++){
            if(check[i]){
                continue;
            }else{
                answer += i;
            }
        }

        return answer;

        // refactoring
        // int sum = 45;
        // for (int i : numbers) {
        //     sum -= i;
        // }
        // return sum;

    }
}