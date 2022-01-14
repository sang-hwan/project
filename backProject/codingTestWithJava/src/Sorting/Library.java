package Sorting;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Library {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, stCount, max, answer;
    static ArrayList<Integer> minus, plus;

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/1461
        // https://hesh1232.tistory.com/134

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        stCount = st.countTokens();
        plus = new ArrayList<>();
        minus = new ArrayList<>();
        for(int i=0; i<stCount; i++){
            int num = Integer.parseInt(st.nextToken());

            if(max<Math.abs(num)){ // 가장 멀리 있는 책
                max = Math.abs(num);
            }

            if(num>0){ // 양수, 음수 구분
                plus.add(num);
            }else{
                minus.add(Math.abs(num));
            }
        }

        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus, Collections.reverseOrder());
        
        for(int i=0; i<plus.size(); i++){
            if(i%M==0 && plus.get(i)==max){
                answer += plus.get(i);
            }else if(i%M==0){
                answer += (plus.get(i)*2);
            }
        }

        for(int i=0; i<minus.size(); i++){
            if(i%M==0 && minus.get(i)==max){
                answer += minus.get(i);
            }else if(i%M==0){
                answer += (minus.get(i)*2);
            }
        }

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();

    }
}
