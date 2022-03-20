package MyMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NegativeBinary{
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/2089
        // https://bellossimo.tistory.com/56

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int input = Integer.parseInt(br.readLine());

        if(input==0){
            System.out.println(0);
        }else{
            while(input!=1){
                sb.append(Math.abs(input%-2));
                input = (int)Math.ceil((double)input/(-2));
            }
            sb.append(input);
            System.out.println(sb.reverse());
        }
    }
}