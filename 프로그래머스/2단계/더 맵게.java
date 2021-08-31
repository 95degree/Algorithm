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
