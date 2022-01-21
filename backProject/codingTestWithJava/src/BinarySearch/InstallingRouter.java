package BinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class InstallingRouter{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, C, result;
    static int[] PointArr;

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/2110
        // https://st-lab.tistory.com/277

        // 첫째줄 입력 N, C
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 둘째줄 입력 집의 위치 PointArr
        PointArr = new int[N];
        for(int i=0; i<PointArr.length; i++){
            PointArr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(PointArr);

        // start, end, result
        int start = 1;
        int end = PointArr[N-1] - PointArr[0];
        
        // 탐색
        while(start<=end){
            int point = PointArr[0];
            int count = 1;
            int mid = (start+end)/2;
            System.out.println("start: "+start+", mid: "+mid+",end: "+end);
            for(int i=0; i<PointArr.length; i++){
                if((PointArr[i]-point)>=mid){
                    count++;
                    point = PointArr[i];
                }
            }
            if(count<C){
                end = mid-1;
            }else{
                start = mid+1;
                result = mid;
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();

    }
}