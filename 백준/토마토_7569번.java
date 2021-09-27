import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int[][][] map;
    static int[][][] days;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] zMove = {1, -1, 0, 0, 0, 0};
    static int[] xMove = {0, 0, 1, -1, 0, 0};
    static int[] yMove = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            map = new int[h][n][m];
            days = new int[h][n][m];
            int answer = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < n; j++) {
                    StringTokenizer str = new StringTokenizer(br.readLine());
                    for (int k = 0; k < m; k++) {
                        int tomato = Integer.parseInt(str.nextToken());
                        map[i][j][k] = tomato;
                    }
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < m; k++) {
                        if (map[i][j][k] == 1) {
                            int[] start = new int[3];
                            start[0] = i;
                            start[1] = j;
                            start[2] = k;
                            queue.add(start);
                        }
                    }
                }
            }
            bfs();
            answer = dayCheck(h, n, m);
            System.out.println(answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int[] check = queue.poll();
            int day = days[check[0]][check[1]][check[2]];
            for (int i = 0; i < zMove.length; i++) {
                int z = check[0] + zMove[i];
                int y = check[1] + yMove[i];
                int x = check[2] + xMove[i];
                if (z < map.length && z >= 0 && y >= 0 && y < map[0].length && x >= 0 && x < map[0][0].length) {
                    if (map[z][y][x] == 0) {
                        int[] tomato = new int[3];
                        tomato[0] = z;
                        tomato[1] = y;
                        tomato[2] = x;
                        queue.add(tomato);
                        map[z][y][x] = 1;
                        days[z][y][x] = day + 1;
                    }
                }
            }
        }
    }

    private static int dayCheck(int h, int n, int m) {
        int answer = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (days[i][j][k] > answer) {
                        answer = days[i][j][k];
                    }
                    if (map[i][j][k] == 0) {
                        answer = -1;
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}
