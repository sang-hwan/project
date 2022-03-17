package MyMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoldbachConjecture {
    public static boolean[] primeList;
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/6588
        // https://maivve.tistory.com/137

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        primeList = new boolean[1000001];
        primeCheck();

        int tc = Integer.parseInt(br.readLine());
        while(tc!=0){
            boolean check = false;
            for(int i=tc-3; 3<=i; i--){
                if(!primeList[i]&&!primeList[tc-1]){
                    sb.append(tc + " = ").append(i > tc - i ? tc - i : i)
					.append(" + ").append(i > tc - i ? i : tc - i).append("\n");
					check = true;
					break;
                }
            }
            if(!check){
                sb.append("Goldbach's conjecture is wrong.");
            }
            tc = Integer.parseInt(br.readLine());
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
