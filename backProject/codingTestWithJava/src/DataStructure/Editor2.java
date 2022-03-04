package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Editor2 {
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/1406
        // https://minhamina.tistory.com/17
        // 시간초과

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());
        List<Character> list = new LinkedList<>();

        for(int i=0; i<str.length(); i++){
            list.add(str.charAt(i));
        }

        int index = list.size();

        while(M-- > 0){
            String[] input = br.readLine().split(" ");
            if(input[0].equals("L")&&0<index){
                index--;
            }else if(input[0].equals("D")&&index<list.size()){
                index++;
            }else if(input[0].equals("B")&&0<index){
                list.remove(index-1);
                index--;
            }else if(input[0].equals("P")){
                list.add(index, input[1].charAt(0));
                index++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Character chr : list){
            sb.append(chr);
        }

        System.out.println(sb);
    }
}
