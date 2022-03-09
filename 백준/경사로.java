import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sr = new StringBuilder();
    static int[][] map;
    static int n;
    static int l;
    static int[] move = {1, -1};
    static boolean[][] visit;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
        for (int j = 0; j < 2; j++) {
            visit = new boolean[n][n];
            boolean yDirection = j == 0;
            for (int i = 0; i < n; i++) {
                if (root(i, yDirection)) {
                    answer++;
                }
            }
        }
    }

    static boolean root(int idx, boolean yDirection) {
        int pre = yDirection ? map[0][idx] : map[idx][0];
        int count = 0;
        for (int i = 0; i < n; i++) {
            int now = yDirection ? map[i][idx] : map[idx][i];
            int height = now - pre;
            if (height == 0) {
                count++;
            } else if (Math.abs(height) == 1) {
                boolean forward = height == 1;
                if (isBuild(idx, i, forward, yDirection)) {
                    build(idx, i, forward, yDirection);
                    count++;
                } else {
                    return false;
                }
            } else {
                return false;
            }
            pre = now;
        }
        return count == n;
    }

    static boolean isBuild(int idx, int seq, boolean forward, boolean yDirection) {
        int direction = forward ? 1 : 0;
        int count = 0;
        int nowIdx = forward ? seq + move[direction] : seq;
        boolean firstVisit = yDirection ? visit[nowIdx][idx] : visit[idx][nowIdx];
        if (!firstVisit) count++;
        int pre = yDirection ? map[nowIdx][idx] : map[idx][nowIdx];
        for (int i = 1; i < l; i++) {
            nowIdx += move[direction];
            if (nowIdx >= 0 && nowIdx < n) {
                int now = yDirection ? map[nowIdx][idx] : map[idx][nowIdx];
                boolean visitCheck = yDirection ? visit[nowIdx][idx] : visit[idx][nowIdx];
                if (visitCheck || pre != now) return false;
                count++;
            }
        }
        return count == l;
    }

    static void build(int idx, int seq, boolean forward, boolean yDirection) {
        int direction = forward ? 1 : 0;
        int nowIdx = forward ? seq + move[direction] : seq;
        for (int i = 0; i < l; i++) {
            if (yDirection) visit[nowIdx][idx] = true;
            else visit[idx][nowIdx] = true;
            nowIdx += move[direction];
        }
    }
    
    static void output() {
        System.out.println(answer);
    }
}
