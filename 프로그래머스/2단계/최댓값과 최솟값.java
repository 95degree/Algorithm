import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split(" ");
        int min = Integer.parseInt(str[0]);
        int max = Integer.parseInt(str[0]);
        for(String a : str){
            int num = Integer.parseInt(a);
            if(num>max){
                max = num;
            }
            if(num<min){
                min = num;
            }
        }
        answer = Integer.toString(min)+" "+Integer.toString(max);
        return answer;
    }
}
