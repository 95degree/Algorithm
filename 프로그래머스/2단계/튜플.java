import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        Map<String,Integer> map = new HashMap<>();
        String[] check = s.replaceAll("[{}]","").replaceAll(","," ").split(" ");
        for(String str : check){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        int idx = map.size();
        answer = new int[idx];
        for(String key : map.keySet()){
           answer[idx- map.get(key)] = Integer.parseInt(key);    
        }
        return answer;
    }
}
