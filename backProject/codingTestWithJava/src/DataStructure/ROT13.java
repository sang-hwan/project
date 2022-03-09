package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ROT13 {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/11655
        // https://bellossimo.tistory.com/34

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        for(int i=0; i<input.length(); i++){
            int c = input.charAt(i);
            if(65<=c&&c<=90){ // 'A'==65, 'Z'==90
                c += 13;
                if(c>90){
                    c -= 26;
                }
                sb.append((char)c);
            }else if(97<=c&&c<=122){ // 'a'==97, 'z'==122
                c += 13;
                if(c>122){
                    c -= 26;
                }
                sb.append((char)c);
            }else{
                sb.append((char)c);
            }
        }
        System.out.println(sb);
    }
}
