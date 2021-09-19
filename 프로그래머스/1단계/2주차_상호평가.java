import java.util.*;

class Solution {
    public String solution(int[][] scores) {
        String answer = "";
        StringBuilder sr = new StringBuilder();
        for(int i =0; i<scores[0].length; i++){
            int min = 101;
            int max = -1;
            int myScore = scores[i][i];
            int check = 0;
            double num = 0;
            for(int j =0; j<scores.length; j++){
                int score = scores[j][i];
                if(j!=i && score==myScore){
                    check++;
                }
                if(score>max){
                    max = score;
                }
                if(score<min){
                    min = score;
                }
                num += score;
            }
            int length = scores.length;
            if((myScore == min || myScore == max) && check ==0){
                num-=myScore;
                length--;
            }
            sr.append(getScore(num/length));
        }
        answer = sr.toString();
        return answer;
    }
  
     private String getScore(double num){
        String score = "";
        if(num>=90){
            score = "A";
        }
        else if(num>=80 && num<90){
            score = "B";
        }
        else if(num>=70 && num<80){
            score = "C";
        }
        else if(num>=50 && num<70){
            score = "D";
        }
        else{
            score = "F";
        }
        return score;
    }
}
