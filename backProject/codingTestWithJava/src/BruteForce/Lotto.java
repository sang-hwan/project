package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lotto{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int k = 1;
    static int[] arr, able;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/6603

        while(k!=0){
            String[] input = br.readLine().split(" ");
            k = Integer.parseInt(input[0]);
            able = new int[k];
            for(int i=1; i<=k; i++){
                able[i-1] = Integer.parseInt(input[i]);
            }
            arr = new int[6];
            dfs(0, 0);
            sb.append("\n");
        }

        System.out.println(sb);
    }
    static void dfs(int at, int depth){
        if(depth==6){
            for(int val:arr){
                sb.append(val+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=at; i<k; i++){
            arr[depth] = able[i];
            dfs(i+1, depth+1);
        }
    }
}