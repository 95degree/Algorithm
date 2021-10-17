import java.util.*;

class Solution {
    public int[] yMove = {1,-1,0,0};
    public int[] xMove = {0,0,-1,1};
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] answer = new int[2];
        boolean[][] map = new boolean[m][n];
        for(int i =0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j]>0 && !map[i][j]){
                    numberOfArea++;
                    map[i][j] = true;
                    maxSizeOfOneArea = Math.max(bfs(i,j,m,n,map,picture),maxSizeOfOneArea);
                }
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    private int bfs(int i, int j, int m, int n, boolean[][]map, int[][] picture){
        Queue<int[]>queue = new LinkedList<>();
        int num = picture[i][j];
        int[] location = {i,j};
        int answer = 0;
        queue.add(location);
        while(!queue.isEmpty()){
            location = queue.poll();
            answer++;
            for(int k =0; k<yMove.length; k++){
                int y = location[0] + yMove[k];
                int x = location[1] + xMove[k];
                if(y>=0 && y<m && x>=0 && x<n){
                    if(!map[y][x] && num==picture[y][x]){
                        int[] newLocation = {y,x};
                        queue.add(newLocation);
                        map[y][x] = true;
                    }
                }
            }
        }
        return answer;
    }
}
