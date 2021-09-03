import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(str.nextToken());
            int m = Integer.parseInt(str.nextToken());
            Queue<Integer> queue = new LinkedList<>();
            queue.add(n);
            int[] check = new int[100001];
            while (!queue.isEmpty()) {
                int x = queue.poll();
                if (x == m) {
                    break;
                }
                for (int i = 0; i < 3; i++) {
                    int num;
                    if (i == 0) {
                        num = x + 1;
                    } else if (i == 1) {
                        num = x - 1;
                    } else {
                        num = 2 * x;
                    }
                    //check에 단계가 있는지 없는지에 따라 방문했는지 안했는지 확인이 가능하다. 이전에 방문한 기록이 가장 최소 단계이다.//
                    if (num >= 0 && num <= 100000 && check[num] == 0) {
                        queue.add(num);
                        check[num] = check[x] + 1;
                    }
                }
            }
            System.out.println(check[m]);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
