import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static char[][] map;
    static int[] moveY = {0,0,-1,1};
    static int[] moveX = {1,-1,0,0};
    static int[][] step;
    static int n;
    static int m;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            n = Integer.parseInt(str.nextToken());
            m = Integer.parseInt(str.nextToken());
            map = new char[n][m];
            step = new int[n][m];
            step[0][0] = 1;
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = 0; j < m; j++) {
                    map[i][j] = line.charAt(j);
                }
            }
            System.out.println(bfs(0,0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int bfs(int startY, int startX) {
        int[] place = new int[2];
        place[0] = startY;
        place[1] = startX;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(place);
        while(!queue.isEmpty()){
            int[] check = queue.poll();
            map[check[0]][check[1]] = '0';
            int previous = step[check[0]][check[1]];
            for(int i =0; i<4; i++){
                int y = check[0] + moveY[i];
                int x = check[1] + moveX[i];
                if(y>=0 && y < n && x < m && x>=0 && map[y][x] == '1'){
                    int[] newCheck = new int[2];
                    newCheck[0] = y;
                    newCheck[1] = x;
                    queue.add(newCheck);
                    map[y][x] = '0';
                    step[y][x] = previous+1;
                    if(y==n-1 && x==m-1){
                        return step[y][x];
                    }
                }
            }
        }
        return step[startY][startX];
    }
}
