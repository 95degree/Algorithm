import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static StringBuilder sr = new StringBuilder();
    static int n;
    static int[] solution;
    static int answer;
    static int v1, v2;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        solution = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            solution[i] = sc.nextInt();
        }

    }

    static void output() {
        Arrays.sort(solution, 1, n + 1);
        answer = Integer.MAX_VALUE;
        for (int left = 1; left <= n - 1; left++) {
            int result = lower_bound(left + 1, n, -solution[left]);
            swap(left, result - 1);
            swap(left, result);
        }
        sr.append(v1).append(' ').append(v2);
        System.out.println(sr.toString());
    }

    static void swap(int left, int result) {
        if (left + 1 <= result && result <= n && Math.abs(solution[result] + solution[left]) < answer) {
            answer = Math.abs(solution[left] + solution[result]);
            v1 = solution[left];
            v2 = solution[result];
        }
    }

    static int lower_bound(int left, int right, int x) {
        int res = right + 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (solution[mid] >= x) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        input();
        output();
    }
}
