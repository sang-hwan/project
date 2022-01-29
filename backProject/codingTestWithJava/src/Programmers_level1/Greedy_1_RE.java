package Programmers_level1;

public class Greedy_1_RE {
    public int solution(int n, int[] lost, int[] reserve) {
        // 출처:
        // https://programmers.co.kr/learn/courses/30/lessons/42862
        // https://programmers.co.kr/learn/courses/30/lessons/42862/solution_groups?language=java

        int[] people = new int[n+2];
        int answer = n;

        for(int l:lost) people[l]--;
        for(int r:reserve) people[r]++;

        for(int i=1; i<=n; i++){
            if(people[i]==-1){
                if(people[i-1]==1){
                    people[i]++;
                    people[i-1]--;
                }else if(people[i+1]==1){
                    people[i]++;
                    people[i+1]--;
                }else{
                    answer--;
                }
            }
        }
        
        return answer;
    }
}
