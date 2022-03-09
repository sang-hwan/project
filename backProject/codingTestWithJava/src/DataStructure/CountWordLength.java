package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountWordLength{
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/2743
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int count = 0;
        for(Character c:input.toCharArray()){
            count++;
        }
        System.out.println(count);
    }
}