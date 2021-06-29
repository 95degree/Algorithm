import java.util.*;
class Solution {
    public String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase().replaceAll("[^-_.a-z0-9]","").replaceAll("[.]{2,}",".")
            .replaceAll("^[.]||[.]$","");
        
        StringBuilder sr = new StringBuilder(new_id);
        
        if(sr.length() == 0){
            sr.append("a");
        }
        
        if(sr.length()>=16){
            sr.delete(15,sr.length());
        }
        
        if(sr.charAt(sr.length()-1) == '.'){
            sr.deleteCharAt(sr.length()-1);
        }
        
        while(sr.length() < 3){
            sr.append(sr.charAt(sr.length()-1));
        }
        answer = sr.toString();
        return answer;
    }
}
