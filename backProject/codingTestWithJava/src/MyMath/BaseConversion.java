package MyMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaseConversion {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/2745

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        int sum = 0;
        for(int i=0; i<N.length(); i++){
            if(N.charAt(i)>='A'){
                sum += (N.charAt(i)-'A'+10) * Math.pow(B, N.length()-i-1);
            }else{
                sum += (N.charAt(i)-'0') * Math.pow(B, N.length()-i-1);
            }
        }
        System.out.println(sum);
    }
}
