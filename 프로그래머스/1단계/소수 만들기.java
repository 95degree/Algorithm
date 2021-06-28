import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                int sum = nums[i]+nums[j];
                for(int k=j+1; k<nums.length; k++){
                    if(checkPrime(sum+nums[k])){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
    
    public boolean checkPrime(int num){
        for(int k=2; k<=(int)Math.sqrt(num); k++){
            if(num%k == 0){
                return false;
            }
        }
        return true;
    }
}
