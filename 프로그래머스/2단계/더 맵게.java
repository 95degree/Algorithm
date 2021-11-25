//최소 스코빌이 K 이상이기만 하면 된다. !!! 일일이 poll할 필요없음//
import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer>queue = new PriorityQueue<>();
        for(int num : scoville){
            queue.add(num);
        }
        while(queue.peek()<K){
            if(queue.size()==1 && queue.peek()<K){
                return -1;
            }
            int firstFood = queue.poll();
            int secondFood = queue.poll();
            queue.add(firstFood+secondFood*2);
            answer++;
        }
        return answer;
    }
}
