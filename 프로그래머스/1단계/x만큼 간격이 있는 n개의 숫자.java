import java.util.*;

class Solution {
    public static long[] solution(int x, int n) {
        long[] answer = new long[n];
        answer[0] = x;
            
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] + x;
        }
        return answer;
    }
}

//BigInteger 나 형변환 필요 없이 그 전 값을 가져와서 + X만 한다. 그 전 값은 이미 long이니까!!!
