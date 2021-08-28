//10을 1로 만들때 그냥 2로 나눠진다고 2로 나누면 10->5->4->3->2->1 4단계를 거치게 되는데
//사실 10에서 1을 먼저 빼면 10->9->3->2->1 3단계로 거치게 된다//
//그러므로 그 전단계와 2나 3로 나눠질때 그 나눈값에 +1한 값과 비교를 해서 최솟값을 집어넣어야한다.//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int [n+1];
            for(int i =2; i<n+1; i++){
                dp[i] = dp[i-1]+1;
                if(i%3 == 0){
                    dp[i] = Math.min(dp[i],dp[i/3]+1);
                }
                if(i%2 ==0){
                    dp[i] = Math.min(dp[i],dp[i/2] + 1);
                }
            }
            System.out.println(dp[n]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
