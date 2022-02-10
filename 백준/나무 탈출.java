import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sr = new StringBuilder();
    static int n;
    static List<List<Integer>> list = new ArrayList<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        input();
        dfs(1, -1, 0);
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            list.get(num1).add(num2);
            list.get(num2).add(num1);
        }
    }

    static void dfs(int idx, int par, int depth) {
        if (idx != 1 && list.get(idx).size() == 1) answer += depth;
        for (int node : list.get(idx)) {
            if (node == par) continue;
            dfs(node, idx, depth + 1);
        }
    }

    static void output() {
        if (answer % 2 == 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
}
