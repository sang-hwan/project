package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CreatePW {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int L, C;
    static char arr[], able[];
    static boolean visit[];

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/1759
        // https://velog.io/@ssojin/%EB%B0%B1%EC%A4%80-1759-%EC%95%94%ED%98%B8%EB%A7%8C%EB%93%A4%EA%B8%B0-Java

        String[] input = br.readLine().split(" ");
        L = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        able = new char[C];
        visit = new boolean[C];
        input = br.readLine().split(" ");
        for(int i=0; i<C; i++){
            able[i] = input[i].charAt(0);
        }
        Arrays.sort(able);
        combination(0, 0);
    }

    static void combination(int start, int cnt){
        if(cnt==L){
            int v = 0; // vowel
            int c = 0; // consonant
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<C; i++){
                if(visit[i]){
                    sb.append(able[i]);
                    if(able[i]=='a'||able[i]=='e'||able[i]=='i'||able[i]=='o'||able[i]=='u'){
                        v++;
                    }else{
                        c++;
                    }
                }
            }
            if(v>=1 && c>=2) System.out.println(sb);
        }
        for(int i=start; i<C; i++){
            visit[i] = true;
            combination(i+1, cnt+1);
            visit[i] = false;
        }
    }
}
