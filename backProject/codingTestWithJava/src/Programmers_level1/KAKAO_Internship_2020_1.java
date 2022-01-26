package Programmers_level1;

public class KAKAO_Internship_2020_1 {

    public String solution(int[] numbers, String hand) {
        // 출처:
        // https://programmers.co.kr/learn/courses/30/lessons/67256
        // https://kangsd.tistory.com/46

        StringBuilder sb = new StringBuilder();
        int left=10, right=12; // 왼손 *(10), 오른손 #(12)
        int L_dis, R_dis; // 왼손 혹은 오른손과의 거리
        for(int n:numbers){
            if(n==1||n==4||n==7){
                sb.append('L');
                left = n; // 왼손 위치
            }else if(n==3||n==6||n==9){
                sb.append('R');
                right = n; // 오른손 위치
            }else{
                if(n==0) n+=11; // zero button 은 11 로 치환
                L_dis = (Math.abs(n-left))/3 + (Math.abs(n-left))%3; // 위아래 이동은 (button 숫자 차이/3)(몫), 좌우 이동은 (button 숫자 차이%3)(나머지)
                R_dis = (Math.abs(right-n))/3 + (Math.abs(right-n))%3;
                if(L_dis==R_dis){
                    if(hand.equals("right")){
                        sb.append('R');
                        right = n;
                    }else{
                        sb.append('L');
                        left = n;
                    }
                }else if(L_dis>R_dis){
                    sb.append('R');
                    right = n;
                }else{
                    sb.append('L');
                    left = n;
                }
            }
        }

        return sb.toString();
    }

}
