import java.util.*;
class Solution {
    public String solution(int n) {
        String answer = "";
        String a = "수";
        String b = "박";
        StringBuilder sr = new StringBuilder();
        for(int i=0; i<n; i++){
            if(i%2 ==0){
                sr.append(a);
            }
            else{
                sr.append(b);
            }
        }
        answer = sr.toString();
        return answer;
    }
}
