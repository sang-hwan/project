package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordReversing{
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/9093
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            String strIn = br.readLine();
            String[] st = strIn.split(" ");

            for(int j=0; j<st.length; j++){
                for(int k=st[j].length()-1; k>=0; k--){
                    sb.append(st[j].charAt(k));
                }
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}