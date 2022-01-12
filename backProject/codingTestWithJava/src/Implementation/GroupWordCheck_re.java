package Implementation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GroupWordCheck_re {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException{       
        // 출처: https://www.acmicpc.net/problem/1316
        // 그룹 단어 체커 문제
        // 그룹 단어 체커: 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우
        // 단어 N개를 입력 받아 그룹 단어의 개수를 출력
        // 단어 개수 N은 100 보다 작은 자연수
        // 단어 길이는 최대 100
        
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i=0; i<N; i++){
            if(check()){
                count++;
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }
    
    public static boolean check() throws IOException{
        boolean[] strArr = new boolean[26];
        String str = br.readLine();
        int prev = 0;

        for(int i=0; i<str.length(); i++){
            int now = str.charAt(i);
            if(prev!=now){
                if(!strArr[now - 'a']){
                    strArr[now - 'a'] = true;
                    prev = now;
                }else{
                    return false;
                }
            }
        }

        return true;
    }
}
