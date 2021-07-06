//처음에 재귀로 풀었다가 시간 초과가 나왔다.
//재귀로 풀지말고 그전에 했던 연산을 계속 유지해 나가는? 방식으로 풀어야 시간초과가 뜨지 않는다.
//그리고 int 범위를 넘어감으로 answer%1234567 = num1%1234567 + num2%1234567 인걸 사용했다.
import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        int num1 = 0;
        int num2 = 1;
        for(int i=2; i<=n; i++){
            answer = num1+num2;
            num1 = num2%1234567;
            num2 = answer%1234567;
        }
        answer%=1234567;
        return answer;
    }
}
