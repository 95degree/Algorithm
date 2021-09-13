import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
           int n = Integer.parseInt(br.readLine());
           int[] f = new int[n+1];
           if(n>0){
               f[1] = 1;
           }
           for(int i =2; i<n+1; i++){
               f[i] = f[i-1] + f[i-2];
           }
            System.out.println(f[n]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
