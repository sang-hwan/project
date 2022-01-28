package Programmers_level1;

public class SnW_Coding_2018_1 {

    public int solution(int[] nums) {
        // 출처:
        // https://programmers.co.kr/learn/courses/30/lessons/12977
        // https://velog.io/@seobob/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%86%8C%EC%88%98%EB%A7%8C%EB%93%A4%EA%B8%B0-Java

        int answer = 0;
        boolean chk = false;

        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    int num = nums[i]+nums[j]+nums[k]; // 3개의 수 조합

                    if(num>=2) chk = sosu(num); // 소수인지 체크
                    if(chk==true) answer++; // 소수이면 경우의 수 +1
                }
            }
        }

        return answer;
    }

    static boolean sosu(int num){
        boolean check = true; // 소수 체크의 if 에 걸리지 않으면 소수기에 true

        if(num==2) return check; // 2 는 소수이기에 true
        for(int i=2; i<num; i++){ // 소수 체크: 2부터 자기자신 보다 1 낮은 수까지 나눠본다
            if(num%i==0){ // 나머지가 0 이면 소수가 아니기에 false
                check = false;
                break;
            }
        }

        return check;
    }

}
