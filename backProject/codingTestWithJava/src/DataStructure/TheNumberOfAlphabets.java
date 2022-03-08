package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheNumberOfAlphabets {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/10809
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int[] arr = new int[26];
        for(Character c:S.toCharArray()){
            arr[c-'a']++;
        }
        for(int i=0; i<26; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
