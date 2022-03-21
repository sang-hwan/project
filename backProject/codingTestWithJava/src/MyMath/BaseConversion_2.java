package MyMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BaseConversion_2 {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/11005
        // https://dundung.tistory.com/24

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
     
        List<Character> list = new ArrayList<>();
        while(N>0){
            if(N%B<10){
                list.add((char)(N%B+'0'));
            }else{
                list.add((char)(N%B-10+'A'));
            }
            N /= B;
        }
        for(int i=list.size()-1; i>=0; i--){
            System.out.print(list.get(i));
        }
    }
}
