import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
            StringBuilder sr = new StringBuilder();
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(br.readLine());
                if (num == 0) {
                    int poll = 0;
                    if (!queue.isEmpty()) {
                        poll = queue.poll();
                    }
                    sr.append(poll).append("\n");
                    continue;
                }
                queue.add(num);
            }
            System.out.println(sr);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
