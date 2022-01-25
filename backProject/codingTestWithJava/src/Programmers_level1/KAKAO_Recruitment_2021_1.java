package Programmers_level1;

public class KAKAO_Recruitment_2021_1 {

    // 출처:
    // https://programmers.co.kr/learn/courses/30/lessons/72410
    // https://zzang9ha.tistory.com/322
    // https://velog.io/@hammii/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%8B%A0%EA%B7%9C-%EC%95%84%EC%9D%B4%EB%94%94-%EC%B6%94%EC%B2%9C-java-2021-KAKAO-BLIND-RECRUITMENT
    
    public static String solution(String new_id) {

        // 1. 소문자
        new_id = new_id.toLowerCase();

        // 2. 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 제외 제거
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
        
        // 3. 마침표(.)가 두개 이상일때 하나로 변경
        new_id = new_id.replaceAll("[.]{2,}", ".");

        // 4. 마침표(.)가 처음이나 마지막에 있으면 제거
        new_id = new_id.replaceAll("^[.]|[.]$", "");
        
        // 5. 공백을 'a'로 변경
        if(new_id.equals("")){
            new_id = "a";
        }

        // 6. 16 글자 이상부터 제거
        if(new_id.length()>=16){
            new_id =  new_id.substring(0, 15);
            new_id = new_id.replaceAll("[.]$", "");
        }

        // 7. 2글자 이하면 마지막 글자를 한 번 더 입력하여 3글자로 변경
        if(new_id.length()<=2){
            while(new_id.length()<3){
                new_id += new_id.charAt(new_id.length()-1);
            }
        }

        String answer = new_id;
        return answer;
    }
}
