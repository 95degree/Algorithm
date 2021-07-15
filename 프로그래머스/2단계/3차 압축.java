//아직 못품//
import java.util.*;
class Solution {
    public int[] solution(String msg) {
        Map<String,Integer>map = new HashMap<>();
        List<Integer>answerList = new ArrayList<>();
        int[] answer = {};
        for(int i =0; i<26; i++){
            map.put(String.valueOf((char)('A'+i)),i+1);
        }
        int index = 26;
        int number = 1;
        String str = msg.substring(0,1);
        while(number<msg.length()){
            str = msg.substring(number-1,number);
            while(map.containsKey(str) && number<msg.length()){
                str += msg.charAt(number++);
            }
            answerList.add(map.get(str.substring(0,str.length()-1)));
            System.out.print(str.substring(0,str.length()-1)+" ");
            if(!map.containsKey(str)){
                map.put(str,++index);
            }
        }
        answerList.add(map.get(str));
        answer = new int[answerList.size()];
        for(int i =0; i<answer.length; i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
