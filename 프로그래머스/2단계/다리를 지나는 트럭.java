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

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int index = 0;
        int sum = 0;
        Queue<Integer>queue = new LinkedList<>();
        for(int i =0; i<bridge_length; i++){
            queue.add(0);
        }
        while(!queue.isEmpty()){
          answer++;
          if(queue.size() == bridge_length){
               sum -= queue.poll();
          }
          if(index<truck_weights.length){
              int truck = truck_weights[index];
              if(sum+truck<=weight && queue.size()<bridge_length){
                  queue.add(truck);
                  index++;
                  sum += truck;
              } else {
                  queue.add(0);
              }
              continue;
          }
          return answer + bridge_length-1;
        }
        return answer;
    }
}
