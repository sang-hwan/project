package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringAnalysis{
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/10820
        // https://dalconbox.tistory.com/217

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while((input=br.readLine())!=null){
            int small=0, capital=0, num=0, blank=0;
            for(Character c:input.toCharArray()){
                if('a'<=c&&c<='z'){
                    small++;
                }else if('A'<=c&&c<='Z'){
                    capital++;
                }else if('0'<=c&&c<='9'){
                    num++;
                }else{
                    blank++;
                }
            }
            System.out.printf("%d %d %d %d\n", small, capital, num, blank);
        }
    }
}