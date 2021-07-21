import java.util.*;
class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        int max = 0;
        for(int num : board[0]){
            if(num == 1){
                max = 1;
            }
        }
        for(int i = 1; i<board.length; i++){
            for(int j= 1; j<board[i].length; j++){
                if(board[i][j] != 0){
                    int check = Math.min(Math.min(board[i-1][j-1],board[i-1][j]),board[i][j-1])+1;
                    board[i][j] = check;
                    if(check>max){
                        max = check;
                    }
                }
            }
        }
        answer = max*max;
        return answer;
    }
}
