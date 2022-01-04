import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sr = new StringBuilder();
    static int n;
    static int m;
    static int[] array;

    static String input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(input());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[m + 1];
        recursive(1);
        System.out.println(sr.toString());
    }

    public static void recursive(int k) {
        if (k == m + 1) {
            for (int i = 1; i <= m; i++) {
                sr.append(array[i]).append(" ");
            }
            sr.append("\n");
        } else {
            int start = array[k - 1];
            for (int i = start + 1; i <= n; i++) {
                array[k] = i;
                recursive(k + 1);
            }
        }
    }
}
