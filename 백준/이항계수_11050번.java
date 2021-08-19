//그냥 풀기//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            System.out.println(factorial(n)/(factorial(k)*factorial(n-k)));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
    private static int factorial(int num){
        int answer = 1;
        for(int i =1; i<=num; i++){
            answer*=i;
        }
        return answer;
    }
}

//재귀 0!은 1이다.//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            System.out.println(factorial(n)/(factorial(k)*factorial(n-k)));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
    private static int factorial(int num){
        if(num<=1){
            return 1;
        }
        return num*factorial(num-1);
    }
}
