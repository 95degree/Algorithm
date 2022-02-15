import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sr = new StringBuilder();
    static int n;
    static int m;
    static List<List<Integer>> list = new ArrayList<>();
    static int[] check;

    public static void main(String[] args) throws IOException {
        input();
        pro();
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        check = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            check[b]++;
        }
    }

    static void pro() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if(check[i] == 0){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            sr.append(x).append(" ");
            for(int idx : list.get(x)){
                check[idx]--;
                if(check[idx] == 0){
                    queue.add(idx);
                }
            }
        }
    }

    static void output() {
        System.out.println(sr);
    }
}
