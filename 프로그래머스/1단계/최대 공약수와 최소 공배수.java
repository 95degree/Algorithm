import java.util.*;
class Solution {
    public int[] solution(int n, int m) {
        int[] answer = {};
        answer = new int[2];
        int max = Math.max(n,m);
        int min = Math.min(n,m);
        while(m !=0){
            int mod = n%m;
            n = m;
            m = mod;
        }
        answer[0] = n;
        answer[1] = (max*min)/n;
        return answer;
    }
}

//두 수의 최대 공약수와 최소 공배수의 곱은 두 수의 곱과 같다
//유클리드 호제법 ( 두 수의 나머지로 두 수 중에 작은 수로 다시 나머지를 구하는 과정을 나머지가 0이 될
//때까지 반복한다. -> 나머지가 0이 되는 식의 작은 수가 최대 공약수이다.)
