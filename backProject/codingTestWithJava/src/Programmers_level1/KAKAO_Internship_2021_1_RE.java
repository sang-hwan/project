package Programmers_level1;

public class KAKAO_Internship_2021_1_RE {

    public static int solution(String s) {

        String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i=0; i<10; i++){
            s = s.replaceAll(strArr[i], Integer.toString(i));
        }

        return Integer.parseInt(s);
    }
}
