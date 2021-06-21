import java.util.*;
class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] monthDay = {31,29,31,30,31,30,31,31,30,31,30,31};
        String[] day ={"THU","FRI","SAT","SUN","MON","TUE","WED"};
        int sum =0;
        for(int i =0; i<a-1; i++){
            sum += monthDay[i];
        }
        answer = day[(sum+b)%7];
        return answer;
    }
}

LocalDate 로 풀기 
LocalDate로 풀기
import java.time.*; -> import time임
class Solution {
    public String solution(int a, int b) {
        String answer = "";
        StringBuilder sr = new StringBuilder(LocalDate.of(2016,a,b).getDayOfWeek().name());
        answer = sr.delete(3,sr.length()).toString();
        return answer;
    }
}
