import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int k = Integer.parseInt(br.readLine());
            List<Integer>list = new ArrayList<>();
            int answer = 0;
            for(int i =0; i<k; i++){
                int num = Integer.parseInt(br.readLine());
                if(num ==0){
                    list.remove(list.size()-1);
                    continue;
                }
                list.add(num);
            }
            for(int num : list){
                answer+=num;
            }
            System.out.println(answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
