package MyMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ACM_Hotel {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/10250

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken()); // 층
            int W = Integer.parseInt(st.nextToken()); // 방
            int N = Integer.parseInt(st.nextToken()); // 손님

            int next = 0;
            while(N>0){
                if(N>H){
                    N -= H;
                    next++;
                }else{
                    if(next>=9){
                        sb.append(N+""+(next+1)+"\n");
                        break;
                    }else{
                        sb.append(N+"0"+(next+1)+"\n");
                        break;
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
