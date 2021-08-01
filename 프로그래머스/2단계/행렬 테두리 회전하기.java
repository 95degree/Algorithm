import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows][columns];
        int num = 1;
        for(int i =0; i<rows; i++){
            for(int j =0; j<columns; j++){
                map[i][j] = num++;
            }
        }
        for(int i =0; i<answer.length; i++){
            answer[i] = turn(map,queries[i]);
        }
        return answer;
    }
    
    public int turn(int[][]map, int[]turnMap){
        int xIndex = turnMap[1] - 1;
        int yIndex = turnMap[0] - 1;
        int first = map[yIndex][turnMap[1]-1];
        int min = first;
        for(int i = yIndex; i<turnMap[2]-1; i++){
            map[i][xIndex] = map[i+1][xIndex];
            yIndex++;
            min = Math.min(map[i][turnMap[1]-1],min);
        }
        for(int i = xIndex ; i<turnMap[3]-1; i++){
            map[yIndex][i] = map[yIndex][i+1];
            min = Math.min(map[yIndex][i],min);
            xIndex++;
            
        }
        for(int i = yIndex; i>turnMap[0]-1; i--){
            map[i][xIndex] = map[i-1][xIndex];
            min = Math.min(map[i][xIndex],min);
            yIndex--;
            
        }
        for(int i = xIndex; i>turnMap[1]-1; i--){
            map[yIndex][i] = map[yIndex][i-1];
            min = Math.min(map[yIndex][i],min);
            xIndex--;
        }
        map[yIndex][xIndex+1] = first;
        return min;
    }
}
