import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static boolean[][] map;
    static boolean[] visit;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(str.nextToken());
            int m = Integer.parseInt(str.nextToken());
            int answer = 0;
            map = new boolean[n + 1][n + 1];
            visit = new boolean[n + 1];

            for (int i = 0; i < m; i++) {
                str = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(str.nextToken());
                int x = Integer.parseInt(str.nextToken());
                map[y][x] = true;
                map[x][y] = true;
            }

            for (int i = 1; i <= n; i++) {
                if (!visit[i]) {
                    dfs(i);
                    answer++;
                }
            }
            System.out.println(answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dfs(int j) {
        visit[j] = true;
        for (int i = 1; i < map[0].length; i++) {
            if (map[j][i] && !visit[i]) {
                dfs(i);
            }
        }
    }
}
