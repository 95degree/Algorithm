//처음 풀이//
import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = i; sum<= n; j++) {
                sum += j;
                if (sum == n) {
                    answer++;
                }
            }
        }
        return answer;
    }
}

//정수론을 찾아보고 해본 풀이//
import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        int num =2;
        int tmp = 1;
        while(tmp>0){
            int sum = 0;
            for(int i = 1; i<=num; i++){
                sum += i;
            }
            tmp = n-sum;
            if(tmp%num == 0){
                answer++;
            }
            num++;
        }
        answer++;
        return answer;
    }
}
