import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder sr = new StringBuilder();
            for (int i = 0; i < n; i++) {
                long[] dp = new long[Integer.parseInt(br.readLine())];
                dp[0] = 1;
                if (dp.length > 1) {
                    dp[1] = 1;
                    if (dp.length > 2) {
                        dp[2] = 1;
                    }
                }
                for (int j = 3; j < dp.length; j++) {
                    dp[j] = dp[j - 2] + dp[j - 3];
                }
                sr.append(dp[dp.length - 1]).append("\n");
            }
            System.out.println(sr);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
