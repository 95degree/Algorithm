import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    static boolean[][] visit;
    static int[] moveX = {0, 0, 1, -1};
    static int[] moveY = {1, -1, 0, 0};

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sr = new StringBuilder();
            int n = Integer.parseInt(br.readLine());
            char[][] map = new char[n][n];
            char[][] eyes = new char[n][n];
            visit = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = 0; j < n; j++) {
                    char color = line.charAt(j);
                    map[i][j] = color;
                    if (color == 'G') {
                        color = 'R';
                    }
                    eyes[i][j] = color;
                }
            }
            sr.append(size(n, map)).append(" ");
            visit = new boolean[n][n];
            sr.append(size(n, eyes));
            System.out.println(sr);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    static int size(int n, char[][] map) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    answer++;
                    bfs(i, j, map);
                }
            }
        }
        return answer;
    }

    static void bfs(int i, int j, char[][] map) {
        int[] check = new int[2];
        check[0] = i;
        check[1] = j;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(check);
        while (!queue.isEmpty()) {
            check = queue.poll();
            char color = map[check[0]][check[1]];
            for (int k = 0; k < moveY.length; k++) {
                int y = check[0] + moveY[k];
                int x = check[1] + moveX[k];
                if (y >= 0 && y < map.length && x >= 0 && x < map.length) {
                    if (map[y][x] == color && !visit[y][x]) {
                        int[] newCheck = new int[2];
                        newCheck[0] = y;
                        newCheck[1] = x;
                        queue.add(newCheck);
                        visit[y][x] = true;
                    }
                }
            }
        }
    }
}
