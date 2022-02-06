import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sr = new StringBuilder();
    static int n;
    static List<List<Integer>> list;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            StringTokenizer sr = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(sr.nextToken());
            int y = Integer.parseInt(sr.nextToken());
            list.get(x).add(y);
            list.get(y).add(x);
        }
    }

    static void dfs(int idx, int par) {
        for (int node : list.get(idx)) {
            if (node == par) continue;
            parent[node] = idx;
            dfs(node, idx);
        }
    }

    static void output() {
        dfs(1, -1);
        for (int i = 2; i < n + 1; i++) {
            sr.append(parent[i]).append("\n");
        }
        System.out.println(sr);
    }
}
