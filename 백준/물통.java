import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sr = new StringBuilder();
    static int n;
    static int m;
    static int v;
    static boolean[][][] check;
    static int[] volume;
    static Set<Integer> set = new TreeSet<>();

    static class Water {

        private int[] amount;

        public Water(int[] water) {
            amount = new int[]{water[0], water[1], water[2]};
        }

        public Water move(int to, int from) {
            int[] newAmount = amount.clone();
            if (amount[to] + amount[from] <= volume[to]) {
                newAmount[to] += newAmount[from];
                newAmount[from] = 0;
            } else {
                newAmount[from] -= volume[to] - newAmount[to];
                newAmount[to] = volume[to];
            }
            return new Water(newAmount);
        }

        public boolean finish() {
            return amount[0] == 0;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        bfs(0, 0, v);
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        volume = new int[]{n, m, v};
        check = new boolean[201][201][201];
    }

    static void bfs(int x, int y, int z) {
        Queue<Water> queue = new LinkedList<>();
        queue.add(new Water(new int[]{x, y, z}));
        check[x][y][z] = true;
        while (!queue.isEmpty()) {
            Water water = queue.poll();
            if (water.finish()) {
                set.add(water.amount[2]);
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) continue;
                    Water newWater = water.move(i, j);
                    if (check[newWater.amount[0]][newWater.amount[1]][newWater.amount[2]]) continue;
                    queue.add(newWater);
                    check[newWater.amount[0]][newWater.amount[1]][newWater.amount[2]] = true;
                }
            }
        }
    }

    static void output() {
        for (Integer integer : set) {
            sr.append(integer).append(" ");
        }
        System.out.println(sr);
    }
}
