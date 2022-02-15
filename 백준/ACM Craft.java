import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sr = new StringBuilder();
    static int n;
    static int m;
    static List<List<Integer>> list;
    static int[] check;
    static int[] done;
    static int[] result;
    static int doneIdx;

    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            check = new int[n + 1];
            done = new int[n + 1];
            result = new int[n + 1];
            for (int i = 0; i < n + 1; i++) {
                list.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                done[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.get(a).add(b);
                check[b]++;
            }
            doneIdx = Integer.parseInt(br.readLine());
            pro();
        }

    }

    static void pro() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (check[i] == 0) {
                queue.add(i);
                result[i] = done[i];
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (x == doneIdx) {
                sr.append(result[x]).append("\n");
                break;
            }
            for (int idx : list.get(x)) {
                check[idx]--;
                result[idx] = Math.max(result[idx], result[x] + done[idx]);
                if (check[idx] == 0) {
                    queue.add(idx);
                }
            }
        }
    }

    static void output() {
        System.out.println(sr);
    }
}
