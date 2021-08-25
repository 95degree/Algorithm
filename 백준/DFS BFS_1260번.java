import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sr = new StringBuilder();

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(str.nextToken());
            int m = Integer.parseInt(str.nextToken());
            int v = Integer.parseInt(str.nextToken());
            boolean[][] map = new boolean[n + 1][n + 1];
            boolean[] check = new boolean[n + 1];
            for (int i = 0; i < m; i++) {
                str = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(str.nextToken());
                int y = Integer.parseInt(str.nextToken());
                map[x][y] = true;
                map[y][x] = true;
            }

            dfs(v, map, check);
            sr.append("\n");
            check = new boolean[n+1];
            bfs(v, map, check);
            System.out.println(sr);
          
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        private static void dfs(int num, boolean[][] map, boolean[] check){
            check[num] = true;
            sr.append(num).append(" ");
            for (int i = 1; i < map[num].length; i++) {
                if (map[num][i] && !check[i]) {
                    dfs(i, map, check);
                }
            }
        }

        private static void bfs(int num, boolean[][]map, boolean[] check){
            check[num] = true;
            Queue<Integer>queue = new LinkedList<>();
            queue.add(num);
            while(!queue.isEmpty()){
                int n = queue.poll();
                sr.append(n).append(" ");
                for(int i = 1; i<map[n].length; i++){
                    if(map[n][i] && !check[i]){
                        queue.add(i);
                        check[i] = true;
                    }
                }
            }
        }
    }
