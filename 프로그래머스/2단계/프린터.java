import java.util. *;

class Solution {
    class Work{
        public int index;
        public int priority;
        
        public Work(int index, int priority){
            this.index = index;
            this.priority = priority;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Work> queue = new LinkedList<>();
        for(int i = 0; i<priorities.length; i++){
            queue.add(new Work(i,priorities[i]));
        }
        
        while(!queue.isEmpty()){
            Work peek = queue.peek();
            boolean flag = true;
            for(Work work : queue){
                if(peek.priority<work.priority){
                    flag = false;
                }
            }
            if(flag){
                Work remove = queue.poll();
                answer++;
                if(remove.index == location){
                    break;
                }
            } else{
                queue.add(queue.poll());
            }
           
        }
        return answer;
    }
}
