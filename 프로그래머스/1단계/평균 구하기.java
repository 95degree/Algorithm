import java.util.*;
class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        int length = arr.length;
        for(int num : arr){
            answer+=num;
        }
        answer/= length;
        return answer;
    }
}
