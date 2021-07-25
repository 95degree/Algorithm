//덱으로 풀어보기//
import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        Arrays.sort(people);
        for(int weight : people){
            deque.add(weight);
        }
        while(!deque.isEmpty()){
            int peek = deque.pollLast();
            answer++;
            if(!deque.isEmpty() &&peek+deque.getFirst() <= limit){
                deque.pollFirst();
            }
        }
        return answer;
    }
}

//단순 for문으로 구현해보기//
import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int minWeightIndex =0;
        int i = people.length-1;
        int j = 0;
        Arrays.sort(people);
        while(i>=j){
            if(people[i]+people[j] <= limit){
                j++;
            }
            i--;
            answer++;
        }
        return answer;
    }
}
