import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int[][] map;
    static int[][] days;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] xMove = {1, -1, 0, 0};
    static int[] yMove = {0, 0, 1, -1};

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int answer = 0;
            map = new int[m][n];
            days = new int[m][n];
            for (int i = 0; i < m; i++) {
                StringTokenizer str = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int tomato = Integer.parseInt(str.nextToken());
                    map[i][j] = tomato;
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1) {
                        int[] start = new int[2];
                        start[0] = i;
                        start[1] = j;
                        queue.add(start);
                    }
                }
            }
            bfs();
            answer = dayCheck(m, n);
            System.out.println(answer);
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int[] check = queue.poll();
            int day = days[check[0]][check[1]];
            for (int i = 0; i < yMove.length; i++) {
                int y = check[0] + yMove[i];
                int x = check[1] + xMove[i];
                if (y >= 0 && y < map.length && x >= 0 && x < map[0].length) {
                    if (map[y][x] == 0) {
                        int[] tomato = new int[3];
                        tomato[0] = y;
                        tomato[1] = x;
                        queue.add(tomato);
                        map[y][x] = 1;
                        days[y][x] = day + 1;
                    }
                }
            }
        }
    }

    private static int dayCheck(int m, int n) {
        int answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (days[i][j] > answer) {
                    answer = days[i][j];
                }
                if (map[i][j] == 0) {
                    answer = -1;
                    return answer;
                }
            }
        }
        return answer;
    }
}
