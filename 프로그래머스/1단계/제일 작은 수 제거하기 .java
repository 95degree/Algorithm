import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[1];
        int min = arr[0]; -> min 0으로 지정해서 헛짓거리 했음 ㅎㅎ
        int j =0;
        if(arr.length == 1){
            answer[0] = -1;
            return answer;
        }
        answer = new int[arr.length-1];
        for(int num : arr){
            if(min-num >= 0){
                min = num;
            }
        }
        for(int i=0; i<answer.length; i++){
            if(arr[i] - min == 0){
                j++; -> 다음 인덱스의 숫자를 넣게 해야함
            }
            answer[i] = arr[j++];
        }
        return answer;
    }
}
