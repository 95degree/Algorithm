import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sr = new StringBuilder();
    static int[][] map;
    static int n;
    static int m;
    static int answer = 0;
    static int[] yMove = {0, 0, -1, 1};
    static int[] xMove = {1, -1, 0, 0};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = true;
                dfs(1, map[i][j], i, j);
                figure(i, j);
                visit[i][j] = false;
            }
        }
    }

    static void dfs(int depth, int sum, int y, int x) {
        if (depth == 4) {
            answer = Math.max(answer, sum);
        } else {
            
            for (int i = 0; i < 4; i++) {
                int newY = y + yMove[i];
                int newX = x + xMove[i];
                if (newY < 0 || newY >= n || newX < 0 || newX >= m) continue;
                if (visit[newY][newX]) continue;
                visit[newY][newX] = true;
                dfs(depth + 1, sum + map[newY][newX], newY, newX);
                visit[newY][newX] = false;
            }
        }
    }

    static void figure(int y, int x) {
        int min = Integer.MAX_VALUE;
        int wing = 4;
        int sum = map[y][x];
        for (int i = 0; i < 4; i++) {
            int newY = y + yMove[i];
            int newX = x + xMove[i];
            if (wing < 3) return;
            if (newY < 0 || newY >= n || newX < 0 || newX >= m) {
                wing--;
                continue;
            }
            min = Math.min(min, map[newY][newX]);
            sum += map[newY][newX];
        }

        if (wing == 4) {
            sum -= min;
        }
        answer = Math.max(answer, sum);
    }


    static void output() {
        System.out.println(answer);
    }
}
