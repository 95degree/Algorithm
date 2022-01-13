import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int i =1; i<=s.length()/2; i++){
            answer = Math.min(compress(s,i),answer);
        }
        return answer;
    }
    
    public int compress(String s, int num){
        StringBuilder sr = new StringBuilder();
        int count = 1;
        int start = 0;
        int last = num;
        String pre = s.substring(start,last);
        String now = "";
        start += num;
        for(last = start+num; last<=s.length(); last+=num){
            now = s.substring(start,last);
            if(now.equals(pre)){
                count++;
            } else {
                if(count>1){
                    sr.append(count);
                    count = 1;
                }
                sr.append(pre);
            }
            pre = now;
            start = last;
        }
        if(count>1){
            sr.append(count);
        }
        sr.append(pre);
        if(start<s.length()){
            sr.append(s.substring(start));
        }
        
        return sr.length();
    }
}
