import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int[] array = new int[n];
            int answer = 0;
            int num = 0;
            StringTokenizer str = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(str.nextToken());
            }
            Arrays.sort(array);
            for (int time : array) {
                num += time;
                answer += num;
            }
            System.out.println(answer);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
