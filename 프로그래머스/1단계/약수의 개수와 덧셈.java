/*사실 제곱수만 항상 약수의 갯수가 홀수이고 나머지는 짝수이다.*/
import java.util.*;
class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i<=right; i++){
            int count = count(i);
            answer += i;
            if(count%2 == 1){
                answer-=2*i;
            }
        }
        return answer;
    }
    
    private int count (int num){
        int max = (int)Math.sqrt(num);
        int answer = 0;
        for(int i = 1; i<=max; i++){
            if(num%i == 0){
                answer+=2;
                if(i*i == num){
                    answer--;
                }
            }
        }
        return answer;
    }
}

import java.util.*;
class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i<=right; i++){
            int num = (int)Math.sqrt(i);
            if(num*num == i){
                answer-= i;
                continue;
            }
            answer+=i;
        }
        return answer;
    }
}
