//문자를 더하다가 끝 문자까지 했을때 break를 나오는 부분 구현을 계속 실수 했다.//
//반복문을 멈춰야 되는 부분을 잘 생각하면서 풀자//
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
        for(int i = 0; i<msg.length(); i++){
            String word = String.valueOf(msg.charAt(i));
            while(map.containsKey(word)){
                i++;
                if(i == msg.length()){
                    break;
                }
                word+=msg.charAt(i);
            }
            if(i==msg.length()){
                answerList.add(map.get(word));
                break;
            }
            answerList.add(map.get(word.substring(0,word.length()-1)));
            map.put(word,++index);
            i--;
        }
        answer = new int[answerList.size()];
        for(int i =0; i<answer.length; i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
