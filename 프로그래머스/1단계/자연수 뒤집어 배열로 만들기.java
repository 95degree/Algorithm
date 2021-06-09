import java.util.*;
class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        String num = Long.toString(n);
        answer = new int[num.length()];
        char[] numArray = num.toCharArray();
        for(int i =0; i< numArray.length; i++){
            answer[i] = numArray[numArray.length-i-1]-'0';
        }
        return answer;
    }
}
