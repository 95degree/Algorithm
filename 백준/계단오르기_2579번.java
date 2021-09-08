import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int[] map = new int[n+1];
            int[] dp = new int[n+1];
            for (int i = 1; i <=n; i++) {
                map[i] = Integer.parseInt(br.readLine());
            }
            dp[1] = map[1];
            if(n>=2){
                dp[2] = map[1] + map[2];
            }
            for(int i =3; i<=n; i++){
                dp[i] = Math.max(dp[i-2], dp[i-3] + map[i-1]) + map[i];
            }
            System.out.println(dp[n]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
