import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[] x1 = {-1,1,0,0};
    public static int[] y1 = {0,0,-1,1};
    public static int[][] ground;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            StringBuilder sr = new StringBuilder();
            for(int i =0; i<t; i++){
                int answer = 0;
                StringTokenizer str = new StringTokenizer(br.readLine());
                int m = Integer.parseInt(str.nextToken());
                int n = Integer.parseInt(str.nextToken());
                ground = new int[n][m];
                int k = Integer.parseInt(str.nextToken());
                for(int j =0; j<k; j++){
                    str = new StringTokenizer(br.readLine());
                    int x = Integer.parseInt(str.nextToken());
                    int y = Integer.parseInt(str.nextToken());
                    ground[y][x] = 1;
                }

                for(int h =0; h<ground.length; h++){
                    for(int p =0; p< ground[h].length; p++){
                        if(ground[h][p] == 1){
                            dfs(h,p);
                            answer++;
                        }
                    }
                }
                sr.append(answer).append("\n");
            }
            System.out.println(sr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dfs(int x, int y){
            for (int i = 0; i < 4; i++) {
                int checkX = x+x1[i];
                int checkY = y+y1[i];
                if(checkX>=0 && checkX< ground.length && checkY>=0 && checkY< ground[0].length){
                    if(ground[checkX][checkY] == 0){
                        continue;
                    }
                    ground[checkX][checkY] = 0;
                    dfs(checkX,checkY);
            }
        }
    }
}
