import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer>queue = new LinkedList<>();
        for(int i =0; i<progresses.length; i++){
            int remain = 100 - progresses[i];
            int day = remain/speeds[i];
            if(remain%speeds[i]>0){
                day++;
            }
            queue.add(day);
        }
        List<Integer>answerList = new ArrayList<>();
        while(!queue.isEmpty()){
            int count = 1;
            int day = queue.poll();
            while(!queue.isEmpty() && day>=queue.peek()){
                count++;
                queue.poll();
            }
            answerList.add(count);
        }
        int[] answer = new int[answerList.size()];
        for(int i =0; i<answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
