import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int num = 0;
        int lastNum = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            char result = dartResult.charAt(i);
            if (result >= '0' && result <= '9') {
                num = result - '0';
                if (i>0 && result == '0' && dartResult.charAt(i-1) == '1')
                    num = 10;
            } else {
                if (result == 'S' || result == 'D' || result == 'T') {
                    if (result == 'D') {
                        num = (int) Math.pow(num, 2);
                    } else if (result == 'T') {
                        num = (int) Math.pow(num, 3);
                    }
                    i++;
                    if (i >dartResult.length() - 1) {
                        answer += num;
                        break;
                }

                }
                if (dartResult.charAt(i) == '*' || dartResult.charAt(i) == '#') {
                    if (dartResult.charAt(i) == '*') {
                        num*=2;
                        answer += lastNum * 2 + num - lastNum;
                    } else {
                        num*=-1;
                        answer += num;
                    }
                    lastNum = num;
                    continue;
                }
                i--;
                answer += num;
                lastNum = num;
            }
        }
        return answer;
    }
}


더 간단하게 푸는 방법
class Solution {
  public int solution(String dartResult) {
      String numTemp="";
        int Answer=0;
        int lastScore=0;
        int num=0;
        char next=' ';
        for(int i=0;i<dartResult.length();i++){
            next=dartResult.charAt(i);
            if(next=='S'||next=='D'||next=='T'){
                lastScore=num;
                num=Integer.parseInt(numTemp);
                if(next=='D'){
                    num*=num;
                }else if(next=='T'){
                    num=num*num*num;
                }
                Answer+=num;
                numTemp="";
            }else if(next=='#'){
                num=-num;
                Answer+=2*num;
            }else if(next=='*'){
                Answer+=num+lastScore;
                num=2*(num);
            }else{
                numTemp=numTemp+next;
            }
        }

      return Answer;
  }
}
