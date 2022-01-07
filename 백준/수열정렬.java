import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static StringBuilder sr = new StringBuilder();
    static int n;
    static int[] answer;
    static Number[] board;

    static class Number implements Comparable<Number> {
        int num;
        int idx;

        public Number(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Number o) {
            return num - o.num;
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new Number[n];
        answer = new int[n];
        for (int i = 0; i < n; i++) {
            board[i] = new Number(sc.nextInt(), i);
        }

    }

    static void output() {
        for (int i = 0; i < n; i++) {
            answer[board[i].idx] = i;
        }
        for (int i : answer) {
            sr.append(i).append(' ');
        }
        System.out.println(sr.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(board);
        output();
    }
}
