import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sr = new StringBuilder();
    static int n;
    static String str;
    static int[] check;
    static int alphabet = 0;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(twoPointer());
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        check = new int[26];
        str = br.readLine();
    }

    static void add(char ch) {
        check[ch - 'a']++;
        if (check[ch - 'a'] == 1) {
            alphabet++;
        }
    }

    static void remove(char ch) {
        check[ch - 'a']--;
        if (check[ch - 'a'] == 0) {
            alphabet--;
        }
    }

    static long twoPointer() {
        int count = 0;
        int start = 0;
        for (int end = 0; end < str.length(); end++) {
            add(str.charAt(end));
            while (alphabet > n) {
                remove(str.charAt(start++));
            }
            count = Math.max(count, end - start + 1);
        }
        return count;
    }

    static void output() {
    }
}
