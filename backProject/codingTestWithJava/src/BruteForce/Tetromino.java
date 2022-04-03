package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tetromino{

    static int[][][] polynominos = {
        // 00
        // 00
		{{0, 0}, {0, 1}, {1, 0}, {1, 1}},
        // 0000
		{{0, 0}, {0, 1}, {0, 2}, {0, 3}}, {{0, 0}, {1, 0}, {2, 0}, {3, 0}},
        // 000
        //  0
		{{0, 0}, {0, 1}, {0, 2}, {1, 1}}, {{0, 0}, {1, 0}, {2, 0}, {1, 1}}, {{1, 0}, {0, 1}, {1, 1}, {2, 1}}, {{1, 0}, {0, 1}, {1, 1}, {1, 2}},
        // 000
        //   0
		{{0, 0}, {0, 1}, {0, 2}, {1, 2}}, {{1, 0}, {1, 1}, {1, 2}, {0, 2}}, {{0, 0}, {1, 0}, {2, 0}, {2, 1}}, {{2, 0}, {0, 1}, {1, 1}, {2, 1}}, {{0, 0}, {0, 1}, {0, 2}, {1, 0}}, {{0, 0}, {1, 0}, {1, 1}, {1, 2}}, {{0, 0}, {1, 0}, {0, 1}, {2, 0}}, {{0, 0}, {0, 1}, {1, 1}, {2, 1}},
        // 0
        // 00
        //  0
		{{0, 0}, {1, 0}, {1, 1}, {2, 1}}, {{1, 0}, {1, 1}, {0, 1}, {0, 2}}, {{0, 0}, {0, 1}, {1, 1}, {1, 2}}, {{0, 1}, {1, 1}, {1, 0}, {2, 0}}
	};
    static int[][] matrix;
    static int maxRes = 0, Row, Col;

    public static void main(String[] args) throws IOException{
        // 출처:
        // https://www.acmicpc.net/problem/14500
        // https://devowen.com/422
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Row = Integer.parseInt(st.nextToken());
        Col = Integer.parseInt(st.nextToken());
        matrix = new int[Row][Col];
        for(int i=0; i<Row; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<Col; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<Row; i++){
            for(int j=0; j<Col; j++){
                calculate(i, j);
            }
        }
        System.out.println(maxRes);
    }
    static void calculate(int row, int col){
        for(int i=0; i<polynominos.length; i++){
            int tmpRes = 0;
            boolean isOk = true;
            for(int j=0; j<4; j++){
                int nRow = row + polynominos[i][j][0];
                int nCol = col + polynominos[i][j][1];
                if(nRow<Row && nCol<Col){
                    tmpRes += matrix[nRow][nCol];
                }else{
                    isOk = false;
                    break;
                }
            }
            if(isOk) maxRes = Math.max(maxRes, tmpRes);
        }
    }
}