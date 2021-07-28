//그냥 break를 안써서 실패 한 거였다니 ㅠㅠㅠㅠ 갑자기 아침에 푸는데 break를 넣어야 한다는 사실을 알게 되었다.//
import java.util.*;
class Solution {
    public boolean[][] map;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] array = new char[m][n];
        map = new boolean[m][n];
        for(int i =0; i<board.length; i++){
           array[i] = board[i].toCharArray(); 
        }
        while(deleteBlock(array)){
            swap(array);
        }
    
        for(int i =0; i<map.length; i++){
            for(int j =0; j<map[i].length; j++){
                if(map[i][j]){
                    answer++;
                }
            }
        }
        return answer;
    }
    
    public boolean deleteBlock(char[][] array){
        boolean bool = false;
         for(int i =1; i<array.length; i++){
            for(int j =1; j<array[i].length; j++){
                char up = array[i-1][j];
                char left = array[i][j-1];
                char sideUp = array[i-1][j-1];
                char peek = array[i][j];
                if(peek != ' ' && up == peek && left == peek && sideUp == peek){
                    map[i-1][j] = true;
                    map[i][j-1] = true;
                    map[i-1][j-1] = true;
                    map[i][j] = true;
                    bool = true;
                }
            }
        }
        return bool;
    }
        
        public void swap(char[][] array){
            for(int i =0 ; i<map.length; i++){
                for(int j = 0; j<map[i].length; j++){
                    if(map[i][j]){
                        array[i][j] = ' ';
                    }
                }
            }
            for(int i =array.length-1; i>=0; i--){
                for(int j = 0; j<array[i].length; j++){
                    if(array[i][j] == ' '){
                        int index = i;
                        while(index>0){
                            index--;
                            if(array[index][j] == ' '){
                                array[i][j] = array[index][j];
                                array[index][j] = ' ';
                                map[i][j] = false;
                                map[index][j] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }        
}
