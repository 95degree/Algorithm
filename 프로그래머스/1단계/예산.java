import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int index =0;
        while(budget>0){
            budget-=d[index++];
            if(budget>=0){
                answer++;
            }
            if(index>=d.length){
                break;
            }
        }
        return answer;
    }
}
