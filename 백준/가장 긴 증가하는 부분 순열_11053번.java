//음 그냥 그렇구나 하면서 이해한정도?? 일일이 손으로 해보면 맞다는걸 알겠는데 .... 이걸 바로 생각해 내고 dp라는것도 알아야 한다니 갈길이 멀다.//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int[] check = new int[n];
            int[] dp = new int[n];
            StringTokenizer str = new StringTokenizer(br.readLine());
            for(int i =0; i<check.length; i++){
                check[i] = Integer.parseInt(str.nextToken());
            }
            for(int i =0; i< dp.length; i++){
                dp[i] = 1;
                for(int j = 0; j<i; j++){
                    if(check[j]<check[i] && dp[i]<dp[j]+1){
                        dp[i] = dp[j] +1;
                    }
                }
            }
            Arrays.sort(dp);
            System.out.println(dp[n-1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
