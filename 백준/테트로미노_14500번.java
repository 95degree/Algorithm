import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[][] map;
    static boolean[][] visit;
    static int answer = 0;
    static int[] yMove = {0, 0, -1, 1};
    static int[] xMove = {-1, 1, 0, 0};

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(str.nextToken());
            int x = Integer.parseInt(str.nextToken());
            map = new int[y][x];
            visit = new boolean[y][x];
            for (int i = 0; i < y; i++) {
                str = new StringTokenizer(br.readLine());
                for (int j = 0; j < x; j++) {
                    map[i][j] = Integer.parseInt(str.nextToken());
                }
            }
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    dfs(0, 0, i, j);
                    fiverDfs(i, j);
                }
            }
            System.out.println(answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
    //sum에 시작점을 넣어주지 않아도 어차피 다른 점에서 그 시작점을 들리기 때문에 굳이 넣어줄 필요가 없다.//
    static void dfs(int depth, int sum, int y, int x) {
        if (depth == 4) {
            if (sum > answer) {
                answer = sum;
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int newY = yMove[i] + y;
            int newX = xMove[i] + x;
            if (newY >= 0 && newY < map.length && newX >= 0 && newX < map[0].length && !visit[newY][newX]) {
                visit[newY][newX] = true;
                dfs(depth + 1, sum + map[newY][newX], newY, newX);
                visit[newY][newX] = false;
            }
        }
    }
    //ㅗ 는 십자형태로 체크하면서 진행하면 된다.
    static void fiverDfs(int y, int x) {
        int sum = map[y][x];
        int min = Integer.MAX_VALUE;
        int wing = 4;
        for (int i = 0; i < 4; i++) {
            int newY = yMove[i] + y;
            int newX = xMove[i] + x;

            if (wing < 3) {
                return;
            }
            if (newY < 0 || newY >= map.length || newX < 0 || newX >= map[0].length) {
                wing--;
                continue;
            }
            min = Math.min(min, map[newY][newX]);
            sum += map[newY][newX];
        }

        if (wing == 4) {
            sum -= min;
        }
        answer = Math.max(sum, answer);
    }
}
