//자기 자신은 빼기 위해 맨 마지막 숫자가 들어간 substring을 만들지 않는다.//
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String,Integer> map = new HashMap<>();
        for(String phon : phone_book){
            map.put(phon,1);
        }
        
        for(String phon : phone_book){
            for(int i =1; i<phon.length(); i++){
                if(map.containsKey(phon.substring(0,i))){
                    return false;
                }
            }
        }
        return answer;
    }
}
