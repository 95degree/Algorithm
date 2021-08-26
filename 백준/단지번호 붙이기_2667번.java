import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[][] map;
    public static int[] indexY = {1,-1,0,0};
    public static int[] indexX = {0,0,-1,1};
    public static int n;


    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());
            int answer = 0;
            StringBuilder sr = new StringBuilder();
            List<Integer>list = new ArrayList<>();
            map = new int[n][n];
            for(int i =0; i<n; i++){
                String str = br.readLine();
                for(int j =0; j< str.length(); j++){
                    map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
                }
            }
            for(int i =0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(map[i][j] == 1){
                        answer++;
                        list.add(bfs(i,j));
                    }
                }
            }
            sr.append(answer).append("\n");
            Collections.sort(list);
            for(int num : list){
                sr.append(num).append("\n");
            }
            System.out.println(sr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static int bfs(int i, int j){
        int answer = 0;
        Queue<int[]>queue = new LinkedList<>();
        int[] position = new int[2];
        position[0] = i;
        position[1] = j;
        queue.add(position);
        while(!queue.isEmpty()){
            position = queue.poll();
            map[position[0]][position[1]] = 0;
            answer++;
            for(int p =0; p<indexX.length; p++){
                int y = position[0] + indexY[p];
                int x = position[1] + indexX[p];
                if(y>=0 && x>=0 && y<n && x<n){
                    if(map[y][x] == 1){
                        int[] tmp = new int[2];
                        tmp[0] = y;
                        tmp[1] = x;
                        map[y][x] = 0;
                        queue.add(tmp);
                    }
                }
            }
        }
        return answer;
    }
}
