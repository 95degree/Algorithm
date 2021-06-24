import java.util.*;
class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left; i<=right; i++){
            int num = count(i);
            if(num%2 ==0){
                answer+=i;
            }
            else{
                answer-=i;
            }
        }
        return answer;
    }
    
    private int count(int num){
        int max = (int)Math.sqrt(num);
        int count =0;
        for(int i=1; i<=max; i++){
            if(num%i == 0){
                count+=2;
                if(i*i == num)
                    count-=1;
            }
        }
        return count;
    }
}
