import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int one;
    static int minus;
    static int zero;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder sr = new StringBuilder();
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer str = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(str.nextToken());
                }
            }
            cut(map);
            sr.append(minus).append("\n").append(zero).append("\n").append(one);
            System.out.println(sr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void cut(int[][] map) {
        int num = map[0][0];
        int answer = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] != num) {
                    if (map.length == 3) {
                        oneCheck(map);
                        return;
                    }
                    int index = map.length / 3;
                    for (int k = 0; k < 3; k++) {
                        int startX = k * index;
                        for (int p = 0; p < 3; p++) {
                            int startY = p * index;
                            cut(makePaper(map, startX, startY, index));
                        }
                    }
                    return;
                } else {
                    answer++;
                }
            }
        }
        if (answer == map.length * map.length) {
            check(num);
        }
    }

    private static int[][] makePaper(int[][] map, int startX, int startY, int index) {
        int[][] newMap = new int[index][index];
        for (int i = 0; i < index; i++) {
            int start = startX + i;
            for (int j = 0; j < index; j++) {
                newMap[i][j] = map[start][startY + j];
            }
        }
        return newMap;
    }

    private static void oneCheck(int[][] map) {
        int num = map[0][0];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                check(map[i][j]);
            }
        }
    }

    private static void check(int num) {
        if (num == 0) {
            zero++;
        } else if (num == 1) {
            one++;
        } else {
            minus++;
        }
    }
}
