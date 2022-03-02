package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parenthesis {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/9012

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            String input = br.readLine();
            boolean[] check = new boolean[input.length()];
            for(int j=0; j<input.length(); j++){
                if(input.charAt(j)=='('&&!check[j]){
                    for(int k=j; k<input.length(); k++){
                        if(input.charAt(k)==')'&&!check[k]){
                            check[j] = true;
                            check[k] = true;
                            break;
                        }
                    }
                }
            }
            sb.append(compare(check, input));
        }
        System.out.println(sb);
    }

    static String compare(boolean[] check, String input){
        for(int x=0; x<input.length(); x++){
            if(!check[x]) return "NO\n";
        }
        return "YES\n";
    }
}
