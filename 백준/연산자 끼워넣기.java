import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sr = new StringBuilder();
    static int n;
    static int[] array;
    static int[] count = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static String input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int[n];
        StringTokenizer sr = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(sr.nextToken());
        }
        sr = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            count[i] = Integer.parseInt(sr.nextToken());
        }
        return br.readLine();
    }

    static void output() {
        sr.append(max).append("\n").append(min);
        System.out.println(sr.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        recursive(0, array[0]);
        output();
    }

    public static void recursive(int k, int num) {
        if (k == n - 1) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        } else {
            for (int i = 0; i < count.length; i++) {
                if (count[i] != 0) {
                    count[i]--;
                    int value = calculator(num, i, array[k + 1]);
                    recursive(k + 1, value);
                    count[i]++;
                }
            }
        }
    }

    public static int calculator(int num, int count, int nextNum) {
        if (count == 0) {
            num += nextNum;
        } else if (count == 1) {
            num -= nextNum;
        } else if (count == 2) {
            num *= nextNum;
        } else {
            num /= nextNum;
        }
        return num;
    }
}
