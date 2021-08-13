import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String next = "0 0 0";
            String check = "";
            StringBuilder sr = new StringBuilder();
            String right = "right";
            String wrong = "wrong";
            while (!(check = br.readLine()).equals(next)) {
               int[] array = Arrays.stream(check.split(" ")).mapToInt(Integer::parseInt).toArray();
               Arrays.sort(array);
               int a = array[0];
               int b = array[1];
               int c = array[2];
               if((a*a) + (b*b) == (c*c)){
                   sr.append(right).append("\n");
                   continue;
               }
               sr.append(wrong).append("\n");
            }
            System.out.println(sr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
