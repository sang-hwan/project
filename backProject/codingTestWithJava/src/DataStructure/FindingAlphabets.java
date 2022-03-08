package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindingAlphabets {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/10809
        // https://st-lab.tistory.com/62

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int[] arr = new int[26];
        Arrays.fill(arr, -1);

        for(int i=0; i<S.length(); i++){
            if(arr[S.charAt(i)-'a']==-1){
                arr[S.charAt(i)-'a'] = i;
            }
        }

        for(int i=0; i<26; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
