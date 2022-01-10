import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static StringBuilder sr = new StringBuilder();
    static int n;
    static int m;
    static int[] x;

    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(x, 1, n + 1);
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = new int[n + 1];
        for (int i = 0; i < n; i++) {
            x[i + 1] = sc.nextInt();
        }
        m = sc.nextInt();

    }

    static void output() {
        System.out.println(search());
    }

    static int search() {
        int left = 1;
        int right = x[x.length - 1];
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid)) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    static boolean check(int d) {
        int count = m;
        for (int money : x) {
            count -= Math.min(money, d);
        }
        return count >= 0;
    }
}
