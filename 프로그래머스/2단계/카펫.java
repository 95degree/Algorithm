//brown + yellow = a*b 
//brown = 2a*2b-4 
import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int block = brown+yellow;
        for(int i =2; i<=Math.abs(block); i++){
            if(block%i == 0){
                int num = block/i;
                if(i>=num && 2*i + 2*num -4 == brown){
                    answer[0] = i;
                    answer[1] = num;
                    break;
                }
            }
        }
        return answer;
    }
}
