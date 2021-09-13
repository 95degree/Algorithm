//3
//26 40 83
//49 60 57
//13 89 99
//1번 index 부터 index-1번에서 맞는 값중에 최솟값을 더해가면된다.//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int[][] check = new int[n][3];
            for (int i = 0; i < n; i++) {
                StringTokenizer str = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    check[i][j] = Integer.parseInt(str.nextToken());
                }
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    check[i][j] += min(check[i - 1], j);
                }
            }
            Arrays.sort(check[n - 1]);
            System.out.println(check[n - 1][0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int min(int[] array, int idx) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (i != idx && min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }
}
