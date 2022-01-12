package Implementation;
import java.util.Scanner;

public class GroupWordCheck {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // 그룹 단어 체커 문제
        // 그룹 단어 체커: 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우
        // 단어 N개를 입력 받아 그룹 단어의 개수를 출력
        // 단어 개수 N은 100 보다 작은 자연수
        // 단어 길이는 최대 100

        // 출처:
        // https://www.acmicpc.net/problem/1316
        // https://st-lab.tistory.com/69

        int count = 0;
        int N = sc.nextInt();

        for(int i=0; i<N; i++){
            if(check()==true){
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean check(){
        // 소문자만 사용
        // z = 122, a = 97
        // 122('z')-97('a') = 25
        // index 가 25까지 있는 배열의 길이 = 26
        boolean[] check = new boolean[26];
        int prev = 0;
        String str = sc.next();

        for(int i=0; i<str.length(); i++){
            int now = str.charAt(i); // i 번째 문자 저장(현재 문자)

            // 앞선 문자와 i 번째 문자가 같이 않을 경우
            if(prev!=now){
                // 해당 문자가 처음 나오는 경우(false 인 경우)
                if(check[now-'a']==false){
                    check[now-'a'] = true; // true 로 바꿔준다
                    prev = now; // 다음 턴을 위해 prev 도 바꿔준다
                }else{
                    // 해당 문자가 이미 나온 적이 있는 경우(그룹 단어가 아니게 됨)
                    return false; // 함수 종료
                }
            }else{
                // 앞선 문자가 i 번째 문자와 다를 경우(연속된 문자)
                // else 문은 없어도 됨
                continue;
            }
        }
        return true;
    }
}
