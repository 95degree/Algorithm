import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        int count =0;
        boolean[] num = new boolean[n+1];
        for(int i=0; i<n+1; i++){
            num[i] = true; 
        }
        
        for(int i=2; i<=(int)Math.sqrt(n); i++){
            if(num[i] == true){
                int j =2;
                while(i*j<=n){
                    num[i*j] = false;
                    j++;
                }
            }
        }
        
        for(boolean check : num){
            if(check == true){
                count++;
            }
        }
        answer = count-2;
        return answer;
    }
}
