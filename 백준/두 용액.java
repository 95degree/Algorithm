//1. 투 포인터, 2. 이분탐색
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static StringBuilder sr = new StringBuilder();
    static int n;
    static int[] w;
    static int answer = Integer.MAX_VALUE;
    static int[] save = new int[2];

    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        w = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(w);
        twoPointer();
    }

    static void twoPointer() {
        int left = 0;
        int right = w.length - 1;
        while (left < right) {
            int sum =w[left] + w[right];
            if (Math.abs(sum) < answer) {
                answer = Math.abs(sum);
                save[0] = w[left];
                save[1] = w[right];
            }
            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
    }

    static void output() {
        System.out.println(save[0] + " " + save[1]);
    }
}

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
