import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        char[] ch = s.toCharArray();
        int count = 0;
        for(char c : ch){
            if(c =='p' || c =='P'){
                count++;
            }
            else if(c =='y' || c=='Y'){
                count--;
            }
        }
        answer = count==0;
        return answer;
    }
}
