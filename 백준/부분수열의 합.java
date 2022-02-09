import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sr = new StringBuilder();
    static int n;
    static int s;
    static int[] nums;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        nums = new int[n];
        if(s == 0) count--;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void dfs(int idx, int num) {
        if (idx == n){
            if(num == s) count++;
        } else {
            dfs(idx + 1, num + nums[idx]);
            dfs(idx + 1, num);
        }
    }

    static void output() {
        dfs(0, 0);
        sr.append(count);
        System.out.println(sr);
    }
}
