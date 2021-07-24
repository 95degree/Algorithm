import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int weightSum = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int truck : truck_weights){
            while(true){
                if(queue.isEmpty()){
                    queue.add(truck);
                    answer++;
                    weightSum+=truck;
                    break;
                }
                else if(queue.size() == bridge_length){
                    weightSum-=queue.poll();
                }
                else if(weightSum+truck<= weight){
                    queue.add(truck);
                    answer++;
                    weightSum+=truck;
                    break;
                }
                else{
                    queue.add(0);
                    answer++;
                }
            }
        }
        answer+=bridge_length;
        return answer;
    }
}
