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

        // 에라토스테네스의 체
        primeList = new boolean[1000001];
        primeList[0] = primeList[1] = true;
        for(int i=2; i<Math.sqrt(primeList.length); i++){
            if(primeList[i]) continue;
            for(int j=i*i; j<primeList.length; j+=i){
                primeList[j] = true;
            }
        }

        // 골드바흐의 추측
        int tc = Integer.parseInt(br.readLine());
        while(tc!=0){
            boolean check = false;
            for(int i=3; i<=tc-3; i++){
                if(!primeList[i]&&!primeList[tc-i]){
                    sb.append(tc+" = "+i+" + "+(tc-i)+"\n");
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

}
