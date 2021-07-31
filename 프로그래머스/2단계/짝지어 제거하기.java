import java.util.*;
class Solution{
    public int solution(String s){
        int answer = 0;
        char[] ch = s.toCharArray();
        Stack<Character>stack = new Stack<>();
        for(int i =0; i< ch.length; i++){
            if(stack.empty()){
                stack.push(ch[i]);
            }
            else if(stack.peek() == ch[i]){
                stack.pop();
            }
            else{
                stack.push(ch[i]);
            }
        }
        if(stack.size()==0){
            return 1;
        }
        return answer;
    }
}
