import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder sr = new StringBuilder();
            PriorityQueue<Integer>queue = new PriorityQueue<>();
            for(int i =0; i<n; i++){
                int num = Integer.parseInt(br.readLine());
                if(num==0){
                    if(!queue.isEmpty()){
                        num = queue.poll();
                    }
                    sr.append(num).append("\n");
                }
                else{
                    queue.add(num);
                }
            }
            System.out.println(sr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
