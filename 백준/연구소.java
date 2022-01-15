//2차원 배열은 clone을 사용해도 깊은 복사가 되지 않는다!!!//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sr = new StringBuilder();
    static int[][] map;
    static List<int[]> virus = new ArrayList<>();
    static int answer = 0;
    static int[] y = {0, 0, -1, 1};
    static int[] x = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        input();
        recursive(0);
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        map = new int[sc.nextInt()][sc.nextInt()];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }

    }

    static void recursive(int count) {
        if (count == 3) {
            answer = Math.max(bfs(map), answer);
            return;
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    recursive(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static int bfs(int[][] map) {
        int check = 0;
        int[][] virusMap = new int[map.length][map[0].length];
        for (int i = 0; i < virusMap.length; i++) {
            System.arraycopy(map[i], 0, virusMap[i], 0, virusMap[i].length);
        }
        Queue<int[]> queue = new LinkedList<>(virus);
        while (!queue.isEmpty()) {
            int[] direction = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newY = direction[0] + y[i];
                int newX = direction[1] + x[i];
                if (newY >= 0 && newY < virusMap.length && newX >= 0 && newX < virusMap[0].length) {
                    if (virusMap[newY][newX] == 0) {
                        virusMap[newY][newX] = 2;
                        int[] newVirus = {newY, newX};
                        queue.add(newVirus);
                    }
                }
            }
        }
        for (int[] ints : virusMap) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    check++;
                }
            }
        }
        return check;
    }

    static void output() {
        System.out.println(answer);
    }
}
