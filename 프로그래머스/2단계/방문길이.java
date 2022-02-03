import java.util.*;

class Solution {
    
    public int[] yMove = {-1,1,0,0};
    public int[] xMove = {0,0,-1,1};
    public boolean[][][][] visit = new boolean[11][11][11][11];
    
    public int solution(String dirs) {
        return move(dirs);
    }
    
    public int move(String dirs){
        int answer = 0;
        int y = 5;
        int x = 5;
        for(int i = 0; i<dirs.length(); i++){
            char dir = dirs.charAt(i);
            int idx = 0;
            if(dir == 'U'){
                idx = 1;
            } else if(dir == 'D'){
                idx = 0;
            } else if(dir == 'L'){
                idx = 2;
            } else {
                idx = 3;
            }
            int newY = y + yMove[idx];
            int newX = x + xMove[idx];
            if(newY<0 || newY>10 || newX<0 || newX>10) continue;
            if(!visit[y][x][newY][newX] && !visit[newY][newX][y][x]){
                visit[y][x][newY][newX] = true;
                visit[newY][newX][y][x] = true;
                answer++;
            }
            y = newY;
            x = newX;
        }
        return answer;
    }
}
