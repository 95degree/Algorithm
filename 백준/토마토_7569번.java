//입력 부분 및 이미 익은 상태 체크 추가 필요//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int[][][] map;
    static int[][][] tmp;
    static int[] zMove = {1,-1,0,0,0,0};
    static int[] xMove = {0,0,1,-1,0,0};
    static int[] yMove = {0,0,0,0,1,-1};
    static int zeroCheck = 0;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            map = new int[h][n][m];
            int answer = 0;
            while(true){
                tmp = map.clone();
                answer++;
                for(int i =0; i<h; i++){
                    for(int j =0; j<n; j++){
                        for(int k =0; k<m; k++){
                            if(tmp[i][j][k] == 1){
                                bfs(i,j,k);
                            }
                        }
                    }
                }
                if(Arrays.deepEquals(tmp,map)){
                    break;
                }
            }

            for(int i =0; i<h; i++){
                for(int j =0; j<n; j++){
                    for(int k =0; k<m; k++){
                        if (map[i][j][k] == -1) {
                            answer = -1;
                            break;
                        }
                    }
                }
            }
            System.out.println(answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void bfs(int h, int n, int m){
        int[] start = new int[3];
        Queue<int []>queue = new LinkedList<>();
        start[0] = h;
        start[1] = n;
        start[2] = m;
        queue.add(start);
        while(!queue.isEmpty()){
            int[] check = queue.poll();
            for(int i =0; i<zMove.length; i++){
                int z = check[0] + zMove[i];
                int y = check[1] + yMove[i];
                int x = check[2] + xMove[i];
                if(z< map.length && y <map[0].length && x <map[0][0].length){
                    if(map[z][y][x] == 0){
                        int[] tomato = new int[3];
                        tomato[0] = z;
                        tomato[1] = y;
                        tomato[2] = x;
                        zeroCheck++;
                        queue.add(tomato);
                        map[z][y][x] = 1;
                    }
                }
            }
        }
    }
}
