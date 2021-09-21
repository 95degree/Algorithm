//stack에서 현재 index의 값보다 큰 값은 제거 하고 index- stack.peek()으로 answer[stack.peek()]에 초를 넣어준다.//
//만약 stack에 주식이 남아있다면 stack에 들어간 마지막 index값보다 다 작으므로 아직 값이 채워지지 않은 answer[index]에 prices.length-l-index로 값을 넣어준다.//
import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer>stack = new Stack<>();
        for(int i =0; i<prices.length; i++){
            while(!stack.isEmpty() && prices[i]<prices[stack.peek()]){
                answer[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int index = stack.pop();
            answer[index] = prices.length-1-index;
        }
        return answer;
    }
}
