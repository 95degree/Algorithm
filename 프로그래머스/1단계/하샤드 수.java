import java.util.*;
class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String[] stringNumberArray = Integer.toString(x).split("");
        int i =0;
        for(String num : stringNumberArray){
            i+=Integer.parseInt(num);
        }
        answer = (x%i)==0;
        return answer;
    }
}

//char로 풀어본 결과 시간이 훨씬 빠르다 메모리는 비슷
import java.util.*;
class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        char[] charNumberArray = Integer.toString(x).toCharArray();
        int i =0;
        for(char charNum : charNumberArray){
            
            i+= charNum-'0';
        }
        answer = (x%i)==0;
        return answer;
    }
}
