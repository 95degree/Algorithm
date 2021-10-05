import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(str.nextToken());
            int money = Integer.parseInt(str.nextToken());
            int answer = 0;
            int[] coins = new int[num];
            for (int i = 0; i < num; i++) {
                coins[i] = Integer.parseInt(br.readLine());
            }
            for (int i = 0; i < coins.length; i++) {
                int coin = coins[coins.length - i - 1];
                if (money - coin >= 0) {
                    int count = money / coin;
                    answer += count;
                    money -= count * coin;
                }
            }
            System.out.println(answer);

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
