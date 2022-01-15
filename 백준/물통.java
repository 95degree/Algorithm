import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sr = new StringBuilder();
    static Water water;
    static boolean check[][][] = new boolean[201][201][201];
    static Set<Integer> set = new TreeSet<>();
    static int[] limit;

    static class Water {
        int x[];

        public Water(int[] water) {
            x = new int[]{water[0], water[1], water[2]};
        }

        public Water move(int to, int from, int[] limit) {
            int[] nX = new int[]{x[0], x[1], x[2]};
            if (x[to] + x[from] <= limit[to]) {
                nX[to] += nX[from];
                nX[from] = 0;
            } else {
                nX[from] -= limit[to] - nX[to];
                nX[to] = limit[to];
            }
            return new Water(nX);
        }

        public boolean possible() {
            return x[0] == 0;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        bfs(0, 0, limit[2]);
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        limit = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()};
    }

    static void output() {
        for (int num : set) {
            sr.append(num).append(" ");
        }
        System.out.println(sr.toString());
    }

    static void bfs(int x1, int x2, int x3) {
        Queue<Water> queue = new LinkedList<>();
        queue.add(new Water(new int[]{x1, x2, x3}));
        check[x1][x2][x3] = true;
        while (!queue.isEmpty()) {
            Water checkWater = queue.poll();
            if (checkWater.possible()) {
                set.add(checkWater.x[2]);
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i != j) {
                        Water next = checkWater.move(i, j, limit);
                        if (!check[next.x[0]][next.x[1]][next.x[2]]) {
                            queue.add(next);
                            check[next.x[0]][next.x[1]][next.x[2]] = true;
                        }
                    }
                }
            }
        }
    }
}
