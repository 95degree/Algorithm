import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int length = nums.length/2;
        Set<Integer> setNum = new HashSet<>();
        for(int num : nums){
            setNum.add(num);
        }
        answer = setNum.size();
        if(length<=setNum.size()){
            answer = length;
        }
        return answer;
    }
}
