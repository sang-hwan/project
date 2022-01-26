package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BestSeller{
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/1302
        // https://zoonvivor.tistory.com/138

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> bookMap = new HashMap<>();
        int N = Integer.parseInt(br.readLine()); // 하루 동안 팔린 책의 개수 N
        for(int i=0; i<N; i++){ // 팔린 책의 제목 입력
            String book = br.readLine();
            if(bookMap.containsKey(book)){
                bookMap.put(book, bookMap.get(book)+1);
            }else{
                bookMap.put(book, 1);
            }
        }

        int max = 0; // 가장 많이 팔린 책
        for(String title:bookMap.keySet()){
            max = Math.max(max, bookMap.get(title));
        }

        // 가장 많이 팔린 책이 다수일 경우 사전 순으로 가장 앞서는 제목의 책을 출력
        ArrayList<String> bookArr = new ArrayList<>(bookMap.keySet());
        Collections.sort(bookArr);
        for(String title:bookArr){
            if(bookMap.get(title)==max){
                System.out.println(title);
                break;
            }
        }
    }
}