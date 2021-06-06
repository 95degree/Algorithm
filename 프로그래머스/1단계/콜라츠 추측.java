import java.util.*;
class Solution {
    public int solution(int num) {
        int answer = 0;
        long number =num;
        while(number!=1){
            if(number%2==0){
                number/=2;
                answer++;
            }
            else{
            number = (number*3)+1;
            answer++;
            }
        }
        if(answer>=500){
            answer = -1;
        }
        return answer;
    }
}

//테스트3(626331) 가 틀려서 long으로 바꾸니 통과 -> 문제를 보고 실행해보지 않고 long이 될 수 있는지 확인 하는 방법이 있을까?
