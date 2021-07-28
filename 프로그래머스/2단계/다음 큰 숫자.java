import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        double check = checkOne(n);
        while(checkOne(n+1)!=check){
            n++;
        }
        answer = n+1;
        return answer;
    }
    
    public double checkOne(int num){
        int check =0;
        String binary = Integer.toBinaryString(num);
        for(int i =0; i<binary.length(); i++){
            if(binary.charAt(i) == '1'){
                check++;
            }
        }
        return check;
    }
}

//bitCount라는 2진수에서 1의 숫자가 몇개인지 알려주는 메소드가 있다.//
class Solution {
    public int solution(int n) {
        int answer = 0;
        int check = Integer.bitCount(n);
        while(Integer.bitCount(n+1)!= check){
            n++;
        }
        answer = n+1;
        return answer;
    }
}
