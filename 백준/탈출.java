import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sr = new StringBuilder();
    static int n;
    static int m;
    static String[] map;
    static int[][] water;
    static int[][] hedgehog;
    static int[] yMove = {0, 0, -1, 1};
    static int[] xMove = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        input();
        bfsWater();
        bfsHedgehog();
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        StringTokenizer str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());
        map = new String[n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine();
        }
        water = new int[n][m];
        hedgehog = new int[n][m];
    }

    static void bfsHedgehog() {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i].charAt(j) == 'S') {
                    queue.add(new int[]{i, j});
                    hedgehog[i][j] = 1;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] newDirection = queue.poll();
            int time = hedgehog[newDirection[0]][newDirection[1]];
            for (int i = 0; i < 4; i++) {
                int newY = newDirection[0] + yMove[i];
                int newX = newDirection[1] + xMove[i];
                if (newY < 0 || newX < 0 || newY >= n || newX >= m) continue;
                if (map[newY].charAt(newX) != '.' && map[newY].charAt(newX) != 'D') continue;
                if (water[newY][newX] != 0 && water[newY][newX] <= time + 1) continue;
                if (hedgehog[newY][newX] == 0) {
                    queue.add(new int[]{newY, newX});
                    hedgehog[newY][newX] = time + 1;
                }
            }
        }
    }

    static void bfsWater() {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i].charAt(j) == '*') {
                    queue.add(new int[]{i, j});
                    water[i][j] = 1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] newDirection = queue.poll();
            int time = water[newDirection[0]][newDirection[1]];
            for (int i = 0; i < 4; i++) {
                int newY = newDirection[0] + yMove[i];
                int newX = newDirection[1] + xMove[i];
                if (newY < 0 || newX < 0 || newY >= n || newX >= m) continue;
                if (map[newY].charAt(newX) != '.') continue;
                if (water[newY][newX] == 0) {
                    queue.add(new int[]{newY, newX});
                    water[newY][newX] = time + 1;
                }
            }
        }
    }

    static void output() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i].charAt(j) == 'D') {
                    if (hedgehog[i][j] == 0) {
                        System.out.println("KAKTUS");
                    } else {
                        System.out.println(hedgehog[i][j] - 1);
                    }
                }
            }
        }
    }
}
