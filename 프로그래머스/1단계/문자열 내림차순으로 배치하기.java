import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        char[] ch = s.toCharArray();
        Arrays.sort(ch); -> char는 내림차순 정렬 안됨
        StringBuilder sr = new StringBuilder(String.valueOf(ch));
        sr.reverse(); -> stringBuilder에 reverse 메소드가 있다.
        answer = sr.toString();
        return answer;
    }
}
