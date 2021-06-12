import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n; i++){
            if(n%i ==0)
                answer+=i;
        }
        return answer;
    }
}

// O(sqrt(n)) 방법 주어진 수의 제곱근 보다 작은 정수의 약수를 구하고 주어진 수로 나눠서 나머지 약수를 구해 더한다.

import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        double num = Math.sqrt(n);
        for(int i=1; i<=(int)num; i++){
            if(n%i ==0){
                int a = n/i;
                answer+=i;
                if(a != i){
                    answer += a;
                }
            }
        }
        return answer;
    }
}
