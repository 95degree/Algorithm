import java.util.*;
class Solution {
    public int[] solution(String[] grid) {
        int[] answer = {};
        int maxLength = 0;
        for(String str : grid){
           maxLength = Math.max(maxLength,str.length());
        }
        Character[][] map = new Character[grid.length][maxLength];
        for(int i = 0 i<grid.length; i++){
            String str = grid[i];
            for(int j =0; i<str.length(); j++){
                map[i][j] = str.charAt(j);
            }
        }
        Set<Integer>set = new Set<>();
        for(int i)
        
        return answer;
    }
}
