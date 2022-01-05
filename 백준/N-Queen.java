import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sr = new StringBuilder();
    static int n;
    static int num;
    static int[] board;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n + 1];
    }

    static void output() {
        sr.append(num);
        System.out.println(sr.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        recursive(1);
        output();
    }

    public static void recursive(int k) {
        if (k == n + 1) {
            num++;
        } else {
            for (int i = 1; i <= n; i++) {
                boolean possible = true;

                //이전에 놓았던 퀸들의 위치를 확인한다.//
                for (int j = 1; j < k; j++) {
                    if (attackable(k, i, j, board[j])) {
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    board[k] = i;
                    recursive(k + 1);
                    board[k] = 0;
                }
            }
        }
    }

    static boolean attackable(int r1, int c1, int r2, int c2) {
        boolean attackable = false;
        if (c1 == c2) {
            attackable = true;
        }
        if (r1 - c1 == r2 - c2) {
            attackable = true;
        }
        if (r1 + c1 == r2 + c2) {
            attackable = true;
        }
        return attackable;
    }
}
