//문자로 풀이//
import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        char[] numArray = Integer.toString(n).toCharArray();
        for(char num : numArray){
            answer+=num-'0';
        }
        return answer;
    }
}

//숫자로 풀이//
import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        while(n>0){
            answer+=n%10;
            n/=10;
        }
        return answer;
    }
}
