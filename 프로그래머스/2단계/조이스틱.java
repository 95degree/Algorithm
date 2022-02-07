import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length()-1;
        
        for(int i = 0; i<name.length(); i++){
            answer += upDown(name.charAt(i));
            int idx = i + 1;
            while(idx < name.length() && name.charAt(idx) == 'A'){
                idx++;
            }
            //현재 A에서 왼쪽으로 다음 A까지 가는 방법 : 2*i + length - idx,  오른쪽으로 다음 A까지는 가는 방법 i + 2*(length - idx) //
            move = Math.min(move, i + name.length() - idx + Math.min(i, name.length() - idx));
        }    
        return answer + move;
    }
    
    public int upDown(char ch){
        return Math.min(ch-'A', 'Z'-ch+1);
    }
}
