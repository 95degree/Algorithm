import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        int[] zeroSize ={-1};
        List<Integer> list = new ArrayList<>();
        for(int num : arr){
            if(num%divisor ==0)
                list.add(num);
        }
        Collections.sort(list);
        if(list.size()==0){
            return zeroSize;
        }
        answer = new int[list.size()];
        for(int i =0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
