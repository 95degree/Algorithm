import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder sr = new StringBuilder();
            String[] people = new String[n];
            for (int i = 0; i < n; i++) {
                people[i] = br.readLine();
            }
            Arrays.sort(people, (o1, o2) -> {
                String[] o1Array = o1.split(" ");
                String[] o2Array = o2.split(" ");
                int o1Age = Integer.parseInt(o1Array[0]);
                int o2Age = Integer.parseInt(o2Array[0]);
                return o1Age-o2Age;
            });
            for(String ageAndName : people){
                sr.append(ageAndName).append("\n");
            }
            System.out.println(sr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
