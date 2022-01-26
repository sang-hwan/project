package Implementation;

public class SelfNum {
    public static void main(String[] args) {
        // 출처:
        // https://www.acmicpc.net/problem/4673
        // https://st-lab.tistory.com/53

        boolean[] check = new boolean[10001];

        for(int i=0; i<=10000; i++){
            int n = d(i);

            if(n<=10000){
                check[n] = true;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<=10000; i++){
            if(!check[i]){
                sb.append(i+"\n");
            }
        }

        System.out.println(sb);
    }

    public static int d(int num){
        int sum = num;

        while(num!=0){
            sum = sum+(num%10);
            num = num/10;
        }

        return sum;
    }
}
