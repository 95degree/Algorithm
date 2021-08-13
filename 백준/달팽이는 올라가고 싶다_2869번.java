import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            long a = Long.parseLong(str.nextToken());
            long b = Long.parseLong(str.nextToken());
            double v = Long.parseLong(str.nextToken());
            System.out.println((int)Math.ceil((v-a)/(a-b))+1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
