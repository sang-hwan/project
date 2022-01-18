package BinarySearch;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Game {
    // 출처: https://www.acmicpc.net/problem/1072
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static double X, Y, preZ, nextZ;
    static int count;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        X = Double.parseDouble(st.nextToken());
        Y = Double.parseDouble(st.nextToken());
        preZ = Math.floor(100*Y/X);

        if(preZ>=99){
            count = -1;
        }else{
            while(nextZ<=preZ){
                X++;
                Y++;
                count++;
                nextZ = Math.floor(100*Y/X);
            }
        }

        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }
}
