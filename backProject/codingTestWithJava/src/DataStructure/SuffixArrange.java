package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SuffixArrange {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/11656

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] suffix = new String[input.length()];
        Arrays.fill(suffix, "");
        for(int i=0; i<input.length(); i++){
            for(int j=i; j<input.length(); j++){
                suffix[i] += input.charAt(j);
            }
        }
        Arrays.sort(suffix);
        for(int i=0; i<suffix.length; i++){
            System.out.println(suffix[i]);
        }
    }
}
