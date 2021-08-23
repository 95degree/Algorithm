import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder sr = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sr.append(fibonacci(Integer.parseInt(br.readLine()))).append("\n");
            }
            System.out.println(sr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String fibonacci(int n) {
        int[] n1 = {0, 1};
        int[] n2 = {1, 0};
        if(n == 1){
            return "0 1";
        }
        if(n == 0){
            return "1 0";
        }
        int[] now = new int[2];
        for (int i = 2; i <= n; i++) {
            now[0] = n1[0] + n2[0];
            now[1] = n1[1] + n2[1];
            n2[0] = n1[0];
            n2[1] = n1[1];
            n1[0] = now[0];
            n1[1] = now[1];
        }
        return now[0] + " " + now[1];
    }
}

//더 이쁘게 풀기//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder sr = new StringBuilder();
            int[] zero = new int[41];
            int[] one = new int[41];
            zero[0] = 1;
            one[1] = 1;
            for (int i = 0; i <n; i++) {
                int num = Integer.parseInt(br.readLine());
                for(int j =2; j<=num; j++){
                    zero[j] = zero[j - 1] + zero[j - 2];
                    one[j] = one[j - 1] + one[j - 2];
                }
                sr.append(zero[num]).append(" ").append(one[num]).append("\n");
            }
            System.out.println(sr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
