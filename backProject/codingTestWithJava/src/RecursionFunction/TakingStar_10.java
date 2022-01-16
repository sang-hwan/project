package RecursionFunction;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TakingStar_10{

    static char[][] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;

    public static void main(String[] args) throws IOException{
        // 출처: 
        // https://www.acmicpc.net/problem/2447
        // https://st-lab.tistory.com/95

        N = Integer.parseInt(br.readLine());

        arr = new char[N][N];

        star(0, 0, N, false);

        for(int i=0; i<N; i++){
            bw.write(arr[i]);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void star(int x, int y, int N, boolean blank){
        if(blank){ // 공백일 경우
            for(int i=x; i<x+N; i++){
                for(int j=y; j<y+N; j++){
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if(N==1){ // 더 이상 쪼갤 수 없는 블록일 때
            arr[x][y] = '*';
            return;
        }

        int size = N/3;
        // N=27 이면 블록 사이즈 9
        // N=9 이면 블록 사이즈 3
        int count = 0;
        // count 를 통해 4번째 마다 공백을 표기
        for(int i=x; i<x+N; i+=size){
            for(int j=y; j<y+N; j+=size){
                count++;
                if(count==5){
                    star(i, j, size, true);
                }else{
                    star(i, j, size, false);
                }
            }
        }
    }
}