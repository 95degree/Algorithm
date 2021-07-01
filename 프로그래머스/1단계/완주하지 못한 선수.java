import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer ="";
        Map<String,Integer> map = new HashMap<>();
        for(int i =0; i<participant.length; i++){
            map.put(participant[i],map.getOrDefault(participant[i],0)+1);
        }
        for(int i =0; i<completion.length; i++){
            map.put(completion[i],map.get(completion[i])-1);
        }
        for(String key : map.keySet()){
            if(map.get(key) == 1){
                answer = key;
            }
        }
        return answer;
    }
}

//정렬로 풀어보기 시간은 훨씬 오래 걸림....
import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer ="";
        Arrays.sort(participant);
        Arrays.sort(completion);
        for(int i =0; i<completion.length; i++){
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        return participant[participant.length-1];
    }
}
