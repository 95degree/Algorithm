//자꾸 for문으로 해서 마지막부문에 꼬이는 현상이 발생했던거 같음 while로 고치고 if문을 아닐경우를 넣었더니 해결//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int target = Integer.parseInt(br.readLine());
            StringBuilder sr = new StringBuilder();
            int[][] map = new int[n][n];
            int[] yMove = {1, 0, -1, 0};
            int[] xMove = {0, 1, 0, -1};
            int start = n * n;
            int startY = 0;
            int startX = 0;
            int targetY = 0;
            int targetX = 0;
            int j = 0;
            map[0][0] = start;
            start--;
            while (start > 0) {
                int newY = startY + yMove[j % 4];
                int newX = startX + xMove[j % 4];
                if (newX < 0 || newX >= n || newY < 0 || newY >= n || map[newY][newX] != 0) {
                    j = (j + 1) % 4;
                    continue;
                }
                startY = newY;
                startX = newX;
                map[newY][newX] = start;
                start--;
            }

            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n; k++) {
                    sr.append(map[i][k]).append(" ");
                    if (map[i][k] == target) {
                        targetY = i + 1;
                        targetX = k + 1;
                    }
                }
                sr.append("\n");
            }
            sr.append(targetY).append(" ").append(targetX);
            System.out.println(sr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
