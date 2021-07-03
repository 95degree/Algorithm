import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer ="";
        char[] phone = {'1','2','3','4','5','6','7','8','9','*','0','#'};
        List<Character> list = new ArrayList<>();
        for(char num : phone){
            list.add(num);
        }
        char left = '*';
        char right = '#';
        StringBuilder sr = new StringBuilder();
        for(int i =0; i<numbers.length; i++){
            char num = (char)(numbers[i] +'0');
            if(num == '1' || num == '4' || num == '7'){
                sr.append("L");
                left = num;
            }
            else if(num == '3' || num == '6' || num == '9'){
                sr.append("R");
                right = num;
            }
            else{
                int leftDistance = distance(list.indexOf(left),list.indexOf(num));
                int rightDistance = distance(list.indexOf(right),list.indexOf(num));
                if(leftDistance>rightDistance){
                    sr.append("R");
                    right = num;
                }
                else if(leftDistance<rightDistance){
                    sr.append("L");
                    left = num;
                }
                else{
                    if(hand.equals("right")){
                        sr.append("R");
                        right = num;
                    }
                    else{
                        sr.append("L");
                        left = num;
                    }
                }
            }
        }
        answer = sr.toString();
        return answer;
    }
    
    public int distance(int handIndex, int numIndex){
        int indexDistance = handIndex - numIndex;
        return Math.abs(indexDistance)%3 + Math.abs(indexDistance)/3;
    }
}
