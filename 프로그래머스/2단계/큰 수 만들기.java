import java.util.*;
class Solution {
      public String solution(String number, int k) {
        String answer = "";
        StringBuilder sr = new StringBuilder();
        int start = 0;
        int check = 0;
        int last = number.length()-k;
        while (k>0) {
            char max = '0';
            for (int i = start; i <= k + start; i++) {
                if (max < number.charAt(i)) {
                    max = number.charAt(i);
                    check = i ;
                }
            }
            k -= check-start;
            start = check+1;
            sr.append(max);
            if(sr.length()==last){
                break;
            }
        }
        if(sr.length()<last){
            sr.append(number.substring(start));
        }
        answer = sr.toString();
        return answer;
    }
}
