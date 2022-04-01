package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CandyGame {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int max, N;
    static char arr[][];

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/3085
        // https://yeeybook.tistory.com/144

        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for(int i=0; i<N; i++){
            String tmp = br.readLine();
            for(int j=0; j<N; j++) arr[i][j] = tmp.charAt(j);
            max = Math.max(max, chkRow(i)); // Row Check Before Swap
        }
        for(int i=0; i<N; i++) max = Math.max(max, chkCol(i)); // Col Check Before Swap

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(j+1 < N){ // in Col Range
                    swap(i, j, i, j+1); // Right Swap
                    max = Math.max(max, chkRow(i));
                    max = Math.max(max, chkCol(j));
                    max = Math.max(max, chkCol(j+1));
                    swap(i, j, i, j+1); // Return
                }
                if(i+1 < N){ // in Row Range
                    swap(i, j, i+1, j); // Down Swap
                    max = Math.max(max, chkRow(i));
                    max = Math.max(max, chkRow(i+1));
                    max = Math.max(max, chkCol(j));
                    swap(i, j, i+1, j); // Return
                }
            }
        }
        System.out.println(max);
    }

    static void swap(int x1, int y1, int x2, int y2){ // Swap
        char tmp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = tmp;
    }

    static int chkRow(int x){ // Row Check
        int tmp = 1, res = 1;
        char ch = arr[x][0];
        for(int i=1; i<N; i++){
            if(arr[x][i]!=ch){
                ch = arr[x][i];
                res = Math.max(res, tmp);
                tmp = 1;
            }else{
                tmp++;
            }
        }
        return Math.max(res, tmp);
    }

    static int chkCol(int y){ // Col Check
        int tmp = 1, res = 1;
        char ch = arr[0][y];
        for(int i=1; i<N; i++){
            if(arr[i][y]!=ch){
                ch = arr[i][y];
                res = Math.max(res, tmp);
                tmp = 1;
            }else{
                tmp++;
            }
        }
        return Math.max(res, tmp);
    }
}
