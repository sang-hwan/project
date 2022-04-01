package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SevenDwarfs{
    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/2309

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        boolean[] check = new boolean[9];
        int sum = 0;
        for(int i=0; i<9; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        int[] liar = new int[2];
        for(int i=0; i<8; i++){
            int tmp_i = sum;
            tmp_i -= arr[i];
            for(int j=i+1; j<9; j++){
                int tmp_j = tmp_i;
                tmp_j -= arr[j];
                if(tmp_j==100){
                    liar[0] = i;
                    liar[1] = j;
                }
            }
        }
        check[liar[0]] = check[liar[1]] = true;
        for(int i=0; i<9; i++){
            if(check[i]){
                arr[i] = 0;
            }
        }
        Arrays.sort(arr);
        for(int i=2; i<9; i++){
            System.out.println(arr[i]);
        }
    }
}