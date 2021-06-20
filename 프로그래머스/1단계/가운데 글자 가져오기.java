import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sr = new StringBuilder();
        int index = s.length()/2;
        if(s.length()%2==0){
            sr.append(s.charAt(index-1));
        }
        sr.append(s.charAt(index));
        answer = sr.toString();
        return answer;
    }
}
