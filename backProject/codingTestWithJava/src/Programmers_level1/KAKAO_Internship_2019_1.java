package Programmers_level1;

import java.util.Stack;

public class KAKAO_Internship_2019_1 {

    public static int solution(int[][] board, int[] moves) {
        // 출처:
        // https://programmers.co.kr/learn/courses/30/lessons/64061
        // https://blog.itcode.dev/posts/2021/12/14/programmers-a0005.html

        Stack<Integer> basket = new Stack<>();
        int answer = 0;

        for(int move:moves){
            int j = move-1;
            for(int i=0; i<board.length; i++){
                if(board[i][j]>0){ // 인형을 뽑을 경우
                    if(!basket.isEmpty()&&basket.peek()==board[i][j]){ // basket 안에 인형이 있고, 이전에 담은 인형과 현재 뽑은 인형이 같을 경우
                        basket.pop();
                        answer += 2;
                    }else{ // basket 안에 인형이 없거나, 이전에 담은 인형과 현재 뽑은 인형이 다를 경우
                        basket.push(board[i][j]);
                    }
                    board[i][j] = 0; // board 에서 뽑힌 인형의 자리는 0 으로 채워준다
                    break;
                }
            }
        }

        return answer;
    }
}
