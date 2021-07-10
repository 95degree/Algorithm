import java.util.*;
class Solution {
    public char[] overTen = {'A','B','C','D','E','F'};
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String a ="0";
        StringBuilder sr = new StringBuilder(a);
        int num = m*t-(m-p);
        int check = 1;
        for(int i = 0; i<=num; i+=a.length()){
            a = revert(check++,n);
            sr.append(a);
        }
        for(int i = 0; i<t; i++){
            answer+=sr.charAt((m*i+(p-1)));
        }
        return answer;
    }
    
    public String revert(int num, int notation){
        StringBuilder sr = new StringBuilder();
        while(num>0){
            int check = num%notation;
            if(notation >10 && check>=10){
                sr.append(overTen[check%10]);
            }
            else{
                sr.append(check);
            }
            num/=notation;
        }
        return sr.reverse().toString();
    }
}
//Integer.toString()으로 진법을 간단히 구할 수 있었다 ㅠㅠㅠ//
import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String a="";
        StringBuilder sr = new StringBuilder();
        int num = m*t-(m-p);
        int check = 0;
        for(int i = 0; i<=num; i+=a.length()){
            a = Integer.toString(check++,n);
            sr.append(a);
        }
        for(int i = 0; i<t; i++){
            answer+=sr.charAt((m*i+(p-1)));
        }
        answer= answer.toUpperCase();
        return answer;
    }
}
