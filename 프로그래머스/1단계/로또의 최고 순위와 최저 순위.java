import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0,0};
        int[] prize = {6,5,4,3,2};
        int zeroNum = 0;
        int winNum =0;
        for(int i=0; i<lottos.length; i++){
            if(lottos[i] == 0){
                zeroNum++;
            }
            for(int j=0; j<win_nums.length; j++){
                if(lottos[i] == win_nums[j]){
                    winNum++;
                    break;
                }
            }
        }
        zeroNum+=winNum;
        for(int i =0; i<prize.length; i++){
            if(zeroNum == prize[i]){
                answer[0] = i+1;
            }
            if(winNum == prize[i]){
                answer[1] = i+1;
            }
        }

        for(int i =0; i<2; i++){
            if(answer[i] == 0){
                answer[i] = 6;
            }
        }
        return answer;
    }
}

//switch로 하는 편인 훨씬 깔끔하긴 하다
import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0,0};
        int[] prize = {6,5,4,3,2};
        int zeroNum = 0;
        int winNum =0;
        for(int i=0; i<lottos.length; i++){
            if(lottos[i] == 0){
                zeroNum++;
            }
            for(int j=0; j<win_nums.length; j++){
                if(lottos[i] == win_nums[j]){
                    winNum++;
                    break;
                }
            }
        }
        zeroNum+=winNum;
        answer[0] = getGrade(zeroNum);
        answer[1] = getGrade(winNum);
        return answer;
    }
    
    public int getGrade(int num) {
        switch(num) {
            case 6 :
                return 1;
            case 5 :
                return 2;
            case 4 :
                return 3;
            case 3 :
                return 4;
            case 2 :
                return 5;
            default :
                return 6;
        }
    }
}
