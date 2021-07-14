import java.util.*;
class Solution {
    public int solution(String s) {
        String[] number = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        int answer = 0;
        for(int i =0; i<number.length; i++){
            s = s.replaceAll(number[i],Integer.toString(i));
        }
        answer = Integer.parseInt(s);
        return answer;
    }
}
