import java.util.*;
class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i =0; i<absolutes.length; i++){
            int sign = 1;
            if(signs[i] == false){
                sign*=-1;
            }
            answer+=absolutes[i]*sign;
        }
        return answer;
    }
}
