import java.util.*;
class Solution {
    Map<String,Integer>map = new HashMap<>();
    Map<String,Integer>tmp = new HashMap<>();
    public int solution(String str1, String str2) {
        int answer = 0;
        cut(str1);
        for(String key : map.keySet()){
            tmp.put(key,map.get(key));
        }
        cut(str2);
        double cross = 0;
        double all = 0;
        for(String key : map.keySet()){
            if(tmp.containsKey(key)){
                cross+= Math.min(map.get(key) - tmp.get(key), tmp.get(key));
            }
            all += map.get(key);
        }
        if(cross == 0 && all-cross == 0){
            return 65536;
        }
        answer = (int)Math.floor((cross/(all-cross))*65536);
        return answer;
    }
    
    private void cut(String str){
        str = str.toUpperCase();
        for(int i =1; i<str.length(); i++){
            String check = str.substring(i-1,i+1);
            if(check.matches("^[a-zA-Z]*$")){
                map.put(check,map.getOrDefault(check,0)+1);
            }
        }
    }
}
