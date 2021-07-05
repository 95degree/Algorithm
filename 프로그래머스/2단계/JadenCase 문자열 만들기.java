import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sr = new StringBuilder();
        s = s.toLowerCase();
        char[] ca = s.toCharArray();
        sr.append(Character.toUpperCase(s.charAt(0)));
        for(int i = 1; i<ca.length; i++){
            char c = ca[i];
            if(ca[i-1]== ' ' && c>='a' && c<='z'){
                c = Character.toUpperCase(ca[i]);
            }
            sr.append(c);
        }
        answer = sr.toString();
        return answer;
    }
}

//그냥 앞에 문자가 빈칸인지 boolean으로 확인만 한다.!!!!//
import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        s = s.toLowerCase();
        StringBuilder sr = new StringBuilder();
        char[] ca = s.toCharArray();
        boolean check = true;
        for(char c : ca){
            c = (check) ? Character.toUpperCase(c):c;
            check = (c == ' ');
            sr.append(c);
        }
        answer = sr.toString();
        return answer;
    }
}
