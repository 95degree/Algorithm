//미리 누적합을 구하고 2~4 index의 구간합은 dp[4] - dp[1]을 하면된다.
//그렇기 때문에 dp의 길이는 n+1로 하는것이 편하다.  1~4의 합을 구할때 dp[4]-dp[0]을 해야 하기 때문 dp[0] = 0
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            StringBuilder sr = new StringBuilder();
            int n = Integer.parseInt(str.nextToken());
            int m = Integer.parseInt(str.nextToken());
            int[] array = new int[n + 1];
            str = new StringTokenizer(br.readLine());
            array[1] = Integer.parseInt(str.nextToken());
            for (int i = 2; i < n + 1; i++) {
                array[i] = array[i - 1] + Integer.parseInt(str.nextToken());
            }
            for (int i = 0; i < m; i++) {
                str = new StringTokenizer(br.readLine());
                int start = array[Integer.parseInt(str.nextToken()) - 1];
                int end = array[Integer.parseInt(str.nextToken())];
                sr.append(end - start).append("\n");
            }
            System.out.println(sr);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            StringBuilder sr = new StringBuilder();
            int n = Integer.parseInt(str.nextToken());
            int m = Integer.parseInt(str.nextToken());
            int[] array = new int[n];
            str = new StringTokenizer(br.readLine());
            array[0] = Integer.parseInt(str.nextToken());
            for (int i = 1; i < n; i++) {
                array[i] = array[i - 1] + Integer.parseInt(str.nextToken());
            }
            for (int i = 0; i < m; i++) {
                str = new StringTokenizer(br.readLine());
                int low = Integer.parseInt(str.nextToken());
                int answer = array[Integer.parseInt(str.nextToken())-1];
                if(low>1){
                    answer-=array[low-2];
                }
                sr.append(answer).append("\n");
            }
            System.out.println(sr);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
