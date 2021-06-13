import java.util.*;
class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        String kim = "Kim";
        StringBuilder sr = new StringBuilder("김서방은 ");
        for(int i =0; i<seoul.length; i++){
            if(seoul[i].equals(kim)){
                sr.append(i);
                break;
            }
                
        }
        sr.append("에 있다");
        answer = sr.toString();
        return answer;
    }
}
