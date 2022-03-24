package MyMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SuccessionOfPrimeNumbers {
    static boolean[] primeList;
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/1644
        // https://velog.io/@hahahaa8642/%EB%B0%B1%EC%A4%80-1644%EB%B2%88-%EC%86%8C%EC%88%98%EC%9D%98-%EC%97%B0%EC%86%8D%ED%95%A9-JAVA-%ED%92%80%EC%9D%B4

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        primeList = new boolean[4_000_001];
        primeCheck();
        ArrayList<Integer> primeNum = new ArrayList<>();
        for(int i=0; i<primeList.length; i++){
            if(!primeList[i]) primeNum.add(i);
        }

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i=0; i<primeNum.size(); i++){
            long sum = 0;
            sum += primeNum.get(i);
            if(primeNum.get(i)==N){
                count++;
            }else{
                for(int j=i; j<primeNum.size(); j++)    {
                    if(i==j) continue;
                    sum += primeNum.get(j);
                    if(sum==N){
                        count++;
                        break;
                    }else if(sum>N){
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }

    static void primeCheck(){
        primeList[0] = primeList[1] = true;
        for(int i=2; i<=Math.sqrt(primeList.length); i++){
            if(primeList[i]) continue;
            for(int j=i*i; j<primeList.length; j+=i){
                primeList[j] = true;
            }
        }
    }
}
