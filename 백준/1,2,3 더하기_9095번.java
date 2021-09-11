//만약 4를 1,2,3 으로 만들 수 있는 방법을 찾는다고 하면
//3을 만드는 방법에 1을 더하거나, 2를 만드는 방법에 2를 더하거나, 1을 만드는 방법에 3을 더하는 방법을 다 합하면 된다.
//그러므로 점화식은 f(n) = f(n-3) + f(n-2) + f(n-1) 이 된다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
           int n = Integer.parseInt(br.readLine());
           StringBuilder sr = new StringBuilder();
            int[] dp = new int[11];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for(int i =4; i<11; i++){
                dp[i] = dp[i-3]+dp[i-2]+dp[i-1];
            }
            for(int i =0; i<n; i++){
                sr.append(dp[Integer.parseInt(br.readLine())]).append("\n");
            }
            System.out.println(sr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
