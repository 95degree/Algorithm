import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    static StringBuilder sr = new StringBuilder();
    static int n;
    static Map<String, Integer> map = new TreeMap<>();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            String[] split = s.split("\\.");
            map.put(split[1], map.getOrDefault(split[1], 0) + 1);
        }

    }

    static void output() {
        for (String s : map.keySet()) {
            sr.append(s).append(" ").append(map.get(s)).append("\n");
        }
        System.out.println(sr);
    }

    public static void main(String[] args) throws IOException {
        input();
        output();
    }
}
