import java.io.*;
import java.util.*;
public class Main {
    public static boolean[][] map;
    public static int min = 64;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer sr = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(sr.nextToken());
        int m = Integer.parseInt(sr.nextToken());
        map = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            char[] array = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = array[j] == 'W';
            }
        }
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                check(i, j);
            }
        }
        System.out.print(min);
        br.close();
    }

    private static void check(int x, int y) {
        boolean start = map[x][y];
        int check = 0;
        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (map[i][j] != start) {
                    check++;
                }
                start = !start;
            }
            start = !start;
        }
        check = Math.min(check, 64 - check);
        min = Math.min(check, min);
    }
}
