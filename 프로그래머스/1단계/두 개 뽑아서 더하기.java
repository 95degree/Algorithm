import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> numSet = new TreeSet<>();
        for(int i =0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                numSet.add(numbers[i]+numbers[j]);
            }
        }
        answer = new int[numSet.size()];
        Iterator<Integer> iterator = numSet.iterator();
        int index =0;
        while(iterator.hasNext()){
            answer[index++] = iterator.next();
        }
        return answer;
    }     
}
