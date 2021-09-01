import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] map;
    static boolean[] visit;
    static int[]check;
    static int n;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sr = new StringBuilder();
            StringTokenizer str = new StringTokenizer(br.readLine());
            n = Integer.parseInt(str.nextToken());
            int m = Integer.parseInt(str.nextToken());
            map = new boolean[n + 1][n + 1];
            int[] answer = new int[n+1];
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                str = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(str.nextToken());
                int x = Integer.parseInt(str.nextToken());
                map[y][x] = true;
                map[x][y] = true;
            }

            for (int i = 1; i < n + 1; i++) {
                int sum = 0;
                for (int j = 1; j < n + 1; j++) {
                    if (j == i) {
                        continue;
                    }
                    visit = new boolean[n + 1];
                    check = new int[n+1];
                    sum += bfs(i, j);
                }
                min = Math.min(min, sum);
                answer[i] = sum;
            }

            for (int i = 1; i < n + 1; i++) {
                if (answer[i] == min) {
                    min = i;
                    break;
                }
            }
            System.out.println(min);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int bfs(int people, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(people);
        while (!queue.isEmpty()) {
            int n = queue.poll();
            visit[n] = true;
            for (int i = 1; i < map[n].length; i++) {
                if (!visit[i] && map[n][i]) {
                    check[i] = check[n]+1;  // 이렇게 처리해야 n과 인접한 i가 몇 단계 인지 정확히 체크가 가능하다.//
                    if (i == target) {
                        return check[i];
                    }
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
        return 0;
    }
}
