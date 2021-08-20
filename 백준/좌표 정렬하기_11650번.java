import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder sr = new StringBuilder();
            String[] array = new String[n];
            for(int i =0; i<n; i++){
                array[i] = br.readLine();
            }
            Arrays.sort(array, (o1, o2) -> {
                StringTokenizer st = new StringTokenizer(o1);
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                st = new StringTokenizer(o2);
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());
                if(x1==x2){
                    return y1-y2;
                }
                return x1-x2;
            });
            for(String xy : array){
                sr.append(xy).append("\n");
            }
            System.out.println(sr);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
