import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static StringBuilder sr = new StringBuilder();
    static int n;
    static int c;
    static int[] house;

    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(house, 1, n + 1);
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        c = sc.nextInt();
        house = new int[n + 1];
        for (int i = 0; i < n; i++) {
            house[i + 1] = sc.nextInt();
        }
    }

    static void output() {
        System.out.println(search());
    }

    static int search() {
        int left = 1;
        int right = 1000000000;
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
        int count = 1;
        int start = house[1];
        for (int i = 2; i < n + 1; i++) {
            if (house[i] - start >= d) {
                start = house[i];
                count++;
            }
        }
        return count >= c;
    }
}
