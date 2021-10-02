import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder sr = new StringBuilder();
            for (int i = 0; i < n; i++) {
                int m = Integer.parseInt(br.readLine());
                int answer = 1;
                Map<String, Integer> map = new HashMap<>();
                for (int j = 0; j < m; j++) {
                    StringTokenizer str = new StringTokenizer(br.readLine());
                    String cloth = str.nextToken();
                    String category = str.nextToken();
                    map.put(category, map.getOrDefault(category, 0) + 1);
                }
                for (String s : map.keySet()) {
                    answer *= map.get(s) + 1;
                }
                sr.append(answer - 1).append("\n");
            }
            System.out.println(sr);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
