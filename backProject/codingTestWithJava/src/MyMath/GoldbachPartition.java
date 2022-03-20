package MyMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoldbachPartition {
    static boolean[] primeList;
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/17103
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        primeList = new boolean[1000001];
        primeCheck();

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            int count = 0;
            for(int j=2; j<=n/2; j++){
                if(!primeList[j]&&!primeList[n-j]){
                    count++;
                }
            }
            sb.append(count+"\n");
        }

        System.out.println(sb);
    }

    static void primeCheck(){
        primeList[0] = primeList[1] = true;
        for(int i=2; i<Math.sqrt(primeList.length); i++){
            if(primeList[i]) continue;
            for(int j=i*i; j<primeList.length; j+=i){
                primeList[j] = true;
            }
        }
    }
}
