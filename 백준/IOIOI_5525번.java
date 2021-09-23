//그냥 IOI 면 더해주는 dp로 풀면 된다.  일일이 문자열 substring비교로 가면 50점 밖에 안된다.//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String oi = "OI";
            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());
            String check = br.readLine();
            int answer = 0;
            int[]dp = new int[m];
            for(int i = 2; i < check.length(); i++) {
                if(check.charAt(i) == 'I' && check.charAt(i-1) =='O' && check.charAt(i-2) =='I'){
                    dp[i] = dp[i-2] + 1;
                }
                if(dp[i]>= n){
                    answer++;
                }
            }
            System.out.println(answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
