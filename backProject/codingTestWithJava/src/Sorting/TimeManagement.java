package Sorting;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TimeManagement {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/1263
        // https://wonit.tistory.com/551

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a1, a2) -> a2[1] - a1[1]);

        int endTime = arr[0][1] - arr[0][0];

        for(int i=1; i<arr.length; i++){
            if(arr[i][1] < endTime){
                endTime = arr[i][1];
            }
            endTime = endTime - arr[i][0];
        }

        if(endTime>0){
            bw.write(Integer.toString(endTime));
            // bw.write(String.valueOf(endTime));
        }else{
            bw.write(Integer.toString(-1));
        }
        bw.flush();
        bw.close();
    }
}
