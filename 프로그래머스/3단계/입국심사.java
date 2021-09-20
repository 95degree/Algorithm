import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long right = n*(long)times[times.length-1];  //n* 최대시간을 했을때 long값이 되므로 둘다 int이기 때문에 하나는 long으로 형변환을 해줘야 올바르게 된다.!!//
        long left = 1;
        while(left<=right){
            long sum = 0;
            long mid = (left+right)/2;
            for(int time : times){
                sum += mid/time;
            }
            if(sum<n){
                left = mid +1;
            }
            else{
                right = mid -1;
            }
        }
        answer = left;
        return answer;
    }
}
