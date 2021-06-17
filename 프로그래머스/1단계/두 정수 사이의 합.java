import java.util.*;
class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        for(int i= Math.max(a,b); i>=Math.min(a,b); i--){
            answer+=i;
        }
        return answer;
    }
}

등차수열로도 가능하다.
  (a+b) * (Maht.abs(a-b)+1)/2
  두 정수 사이의 갯수 * 두 정수의 합 /2  -> 왜 1부터 n까지의 합이 (n*(n+1))/2인지 잘 생각해보자
