import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] map;
    static boolean[] visit;
    static int n;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sr = new StringBuilder();
            StringTokenizer str = new StringTokenizer(br.readLine());
            n = Integer.parseInt(str.nextToken());
            int m = Integer.parseInt(str.nextToken());
            map = new boolean[n + 1][n + 1];
            int[] answer = new int[n + 1];
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                str = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(str.nextToken());
                int x = Integer.parseInt(str.nextToken());
                map[y][x] = true;
                map[x][y] = true;
            }

            for (int i = 1; i < n + 1; i++) {
                visit = new boolean[n + 1];
                int kevin = sum(bfs(i));
                min = Math.min(min, kevin);
                answer[i] = kevin;
            }

            for (int i = 1; i < n + 1; i++) {
                if (answer[i] == min) {
                    min = i;
                    break;
                }
            }
            System.out.println(min);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] bfs(int people) {
        int[] check = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(people);
        while (!queue.isEmpty()) {
            int n = queue.poll();
            visit[n] = true;
            for (int i = 1; i < map[n].length; i++) {
                if (!visit[i] && map[n][i]) {
                    check[i] = check[n] + 1;
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
        return check;
    }

    private static int sum(int[] count) {
        int sum = 0;
        for (int number : count) {
            sum += number;
        }
        return sum;
    }
}
