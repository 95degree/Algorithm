import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for(int i =0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ')'){
                if(stack.empty()){
                    return false;
                }   
                 stack.pop();
            }
            else{
                stack.push('(');
            }
        }
        answer = stack.empty();
        return answer;
    }
}

//스택 안쓰고 풀기//
class Solution {
    boolean solution(String s) {
        boolean answer = false;
        int count = 0;
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i) == '('){
                count++;
            }
            if(s.charAt(i) == ')'){
                count--;
            }
            if(count < 0){
                break;
            }
        }
        if(count == 0){
            answer = true;
        }
        return answer;
    }
}
