package Programmers_Test;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class test_04M02D{
    public static void main(String[] args){
        int[][] dist =
        {{0,5,2,4,1},
        {5,0,3,9,6},
        {2,3,0,6,3},
        {4,9,6,0,3},
        {1,6,3,3,0}};

        int[][] answer = new int[2][dist.length];
        answer = Solution(dist);
    }

    static int[][] Solution(int[][] dist){

        Queue left = new LinkedList<>();
        Stack right = new Stack<>();
        boolean[] check = new boolean[dist.length];
        boolean LRchk = true;
        int tmp = 0;
        int fixed = 0;
        int inner = 0;
        for(int i=0; i<dist.length-1; i++){
            int max = 0;
            check[tmp] = true;
            for(int j=0; j<dist.length; j++){
                if(!check[j]&&max<=dist[fixed][j]){
                    max = Math.max(max, dist[fixed][j]);
                    tmp = j;
                }
            }
            if(fixed==0){
                left.offer(tmp);
                inner = max;
            }else{
                if(LRchk && inner-max>0){
                    left.offer(tmp);
                    inner = max;
                }else if(LRchk && inner-max<=0){
                    right.push(tmp);
                    inner = max - inner;
                    LRchk = false;
                }else if(!LRchk && inner-max>0){
                    right.push(tmp);
                    inner = max;
                }else{
                    left.offer(tmp);
                    inner = max - inner;
                    LRchk = true;
                }
            }
            fixed = tmp;
        }

        int[][] answer = new int[2][dist.length];
        int index = 0;
        while(!left.isEmpty()){
            answer[0][index] = (int)left.poll();
            index++;
        }
        answer[0][index] = 0;
        index++;
        while(!right.isEmpty()){
            answer[0][index] = (int)right.pop();
            index++;
        }
        for(int i=0; i<dist.length; i++){
            answer[1][i] = answer[0][(dist.length-1)-i];
        }
        
        return answer;
    }
}