import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int lastMultiple = multiple(arr[0],arr[1]);
        for(int i =2; i<arr.length; i++){
            int multipleNum = multiple(lastMultiple,arr[i]);
            lastMultiple = multipleNum;
        }
        answer = lastMultiple;
        return answer;
    }
    
    private int multiple(int num1, int num2){
        return (num1*num2)/gcd(num1,num2);
    }
    
    private int gcd(int num1, int num2){
        int divisor =  num1%num2;
        while(divisor>0){
            num1 = num2;
            num2 = divisor;
            divisor = num1%num2;
        }
        return num2;
    }
}
