import java.util.*;
class Solution {
    public class Boxer{
        int weights;
        double winRate;
        int winHeavy;
        int number;

        public Boxer(int weights, double winRate, int number, int winHeavy){
            this.weights = weights;
            this.winRate = winRate;
            this.number = number;
            this.winHeavy = winHeavy;
        }
    }

    public int[] solution(int[] weights, String[] head2head) {

        int[] answer = new int[weights.length];
        int[] heavyWin = new int[weights.length];
        Boxer[] boxers = new Boxer[weights.length];

        for(int i = 0; i<head2head.length; i++){
            String win = head2head[i];
            double winCheck = 0;
            int notGame = 0;
            for(int j =0; j<win.length(); j++){
                if(win.charAt(j)=='W'){
                    winCheck++;
                    if(weights[i]<weights[j]){
                        heavyWin[i]++;
                    }
                }
                else if(win.charAt(j)=='N'){
                    notGame++;
                }
            }
            double rate = winCheck/(win.length()-notGame);
            if(win.length()==notGame){
                rate = 0;
            }
            boxers[i] = new Boxer(weights[i],rate,i,heavyWin[i]);
        }

        Arrays.sort(boxers,(o1,o2) ->{
            int compare = Double.compare(o2.winRate,o1.winRate);
            if(compare == 0){
                if(o2.winHeavy==o1.winHeavy){
                    if(o2.weights==o1.weights){
                        return o1.number - o2.number;
                    }
                    return o2.weights - o1.weights;
                }
                return o2.winHeavy - o1.winHeavy;
            }
            return compare;
        });
        
        for(int i =0; i<boxers.length; i++){
            answer[i] = boxers[i].number+1;
        }
        return answer;
    }
}
