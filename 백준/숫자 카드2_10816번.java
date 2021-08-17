import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
           Map<Long,Integer> map = new HashMap<>();
           StringBuilder sr = new StringBuilder();
           int n = Integer.parseInt(br.readLine());
           StringTokenizer st = new StringTokenizer(br.readLine());
           for(int i =0; i<n; i++){
               long num = Long.parseLong(st.nextToken());
               map.put(num,map.getOrDefault(num,0)+1);
           }
           int m = Integer.parseInt(br.readLine());
           st = new StringTokenizer(br.readLine());
           for(int i =0; i<m; i++){
               long num = Long.parseLong(st.nextToken());
               sr.append(map.getOrDefault(num,0)).append(" ");
           }
            System.out.println(sr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
