import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            StringBuilder sr = new StringBuilder();
            int n = Integer.parseInt(str.nextToken());
            int m = Integer.parseInt(str.nextToken());
            Map<String,Integer> map = new TreeMap<>();
            for(int i =0; i<n+m; i++){
                String name = br.readLine();
                map.put(name, map.getOrDefault(name,0)+1);
            }
            Set<String> set = map.keySet();
            int answer = 0;
            for(String name : set){
                if(map.get(name)==2){
                    sr.append(name).append("\n");
                    answer++;
                }
            }
            sr.insert(0,answer+"\n");
            System.out.println(sr);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
