import java.util.*;
class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int [5];
        for(int i =0; i<places.length; i++){
            answer[i] = check(places[i]);
        }
        return answer;
    }
    private int check(String[] place){
        char [][] xy = new char[5][5];
        int[] checkX = {1,0,0,1,1,2};
        int[] checkY = {-1,1,2,1,0,0};
        for(int i =0; i<5; i++){
            String room = place[i];
            for(int j =0; j<5; j++){
                xy[i][j] = room.charAt(j);
            }
        }
        for(int i =0; i<5; i++){
            for(int j =0; j<5; j++){
                if(xy[i][j] == 'P'){
                    for(int k =0; k<6; k++){
                        int x = checkX[k];
                        int y = checkY[k];
                        if(i+x<5 && j+y<5 && j+y>=0){
                            if(xy[i+x][j+y] == 'P'){
                                if(x==1 && y==1 && xy[i+1][j] == 'X' && xy[i][j+1] == 'X'){
                                    continue;
                                }
                                else if(y==-1 && xy[i][j-1] == 'X' && xy[i+1][j] == 'X'){
                                    continue;
                                }
                                else if(x==2 && xy[i+1][j] == 'X'){
                                    continue;
                                }
                                else if(y==2 && xy[i][j+1] == 'X'){
                                    continue;
                                }
                                return 0;
                            }
                        }
                    }
                }
            }
        }
        return 1;
    }
}

//DFS로 풀기//
class Solution {
    public int[] checkX = {1,-1,0,0};
    public int[] checkY = {0,0,1,-1};

    public int[] solution(String[][] places) {
        int[] answer = new int [5];
        for(int i =0; i<places.length; i++){
            answer[i]=check(room(places[i]));
        }
        return answer;
    }

    private char[][] room(String[] place){
        char[][] room = new char[5][5];
        for(int i =0; i<place.length; i++){
            String str = place[i];
            for(int j =0; j<str.length(); j++){
                room[i][j] = str.charAt(j);
            }
        }
        return room;
    }

    private int check(char[][] room){
        for(int i =0; i<room.length; i++){
            for(int j =0; j<room[i].length; j++){
                if(room[i][j] == 'P'){
                   if(dfs(i,j,room,0)==0){
                       return 0;
                   }
                }
            }
        }
        return 1;
    }

    private int dfs(int y, int x, char[][]room, int depth){
        room[y][x] = 'X';
        for(int i =0; i<checkX.length; i++){
            int y1 = y+checkY[i];
            int x1 = x+checkX[i];
            if(y1>=0 && x1>=0 && y1<5 && x1<5){
                if(room[y1][x1] == 'O' && depth == 0){
                    room[y1][x1] = 'X';
                    if(dfs(y1,x1,room,depth+1) == 0){
                        return 0;
                    }
                    else{
                        continue;
                    }
                }
                if(room[y1][x1] == 'P'){
                    return 0;
                }
            }
        }
        return 1;
    }
}
