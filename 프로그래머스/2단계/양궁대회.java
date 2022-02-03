import java.util.*;

class Solution {
    
    int[] lion;
    int[] appich;
    int maxGap = 0;
    int shot;
    boolean flag;
    
    public int[] solution(int n, int[] info) {
        appich = info;
        int[] answer = new int[11];
        lion = new int[11];
        dfs(0, n, answer);
        if(!flag){
            return new int[]{-1};
        }
        return lion;
    }
    
    public void dfs(int idx, int left, int[] answer){
        if(idx==10){
            int lionScore = 0;
            int appichScore = 0;
            int minShot = 10;
            answer[idx] = left;
            for(int i =0; i<11; i++){
                if(answer[i]>0 && minShot>10-i){
                    minShot = 10-i;
                }
                
                if(answer[i]>appich[i]){
                    lionScore += (10-i);
                } else {
                    if(appich[i]>0){
                      appichScore += (10-i);  
                    }
                }
            }
            
            int gap = lionScore - appichScore;
            
            if(gap>maxGap){
                lion = answer.clone();
                maxGap = gap;
                shot = minShot;
                flag = true;
                return;
            }
            
            if(gap == maxGap && (minShot<shot || (minShot==shot && answer[10-minShot]>lion[10-minShot]))){
                lion = answer.clone();
                shot = minShot;
                flag = true;
                return;
            }
            return;
        }
        
        for(int i=0; i<=left; i++){
            answer[idx] = i;
            dfs(idx+1,left-i,answer);
            answer[idx] = 0;
        }
    }
}
