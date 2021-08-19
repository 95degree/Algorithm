import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder sr = new StringBuilder();
            int[] array = new int[n];
            for(int i =0; i<n; i++){
                array[i]= Integer.parseInt(br.readLine());
            }
            Arrays.sort(array);
            for(int num : array){
                sr.append(num).append("\n");
            }
            System.out.println(sr);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
