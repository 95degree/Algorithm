import java.util.*;
class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int[] array = new int[land[0].length];
        for(int i =1; i<land.length; i++){
            for(int j =0; j<land[0].length; j++){
                land[i][j] += max(land[i-1],j);
            }
        }
        
        for(int i =0; i<land[0].length; i++){
            array[i] = land[land.length-1][i];
        }
        
        Arrays.sort(array);
        answer = array[array.length-1];
        return answer;
    }
    
    public int max(int[] array, int num){
        int max = 0;
        for(int i =0; i<array.length; i++){
            if(max<=array[i] && i!=num)
                max = array[i];
        }
        return max;
    }
}
