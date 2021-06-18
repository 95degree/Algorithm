import java.util.*;
public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        int tmp = arr[0];
        list.add(tmp);
        for(int num : arr){
            if(tmp != num){
                list.add(num);
                tmp = num;
            }
        }
        int size = list.size();
        answer = new int[size];
        for(int i =0; i<size; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
