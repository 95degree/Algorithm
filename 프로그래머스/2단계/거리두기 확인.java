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
