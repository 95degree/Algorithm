import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
           int n = Integer.parseInt(br.readLine());
           int[] f = new int[n+1];
           f[1] = 1;
           if(n>1){
               f[2] = 2;
           }
           for(int i =3; i<n+1; i++){
               f[i] = (f[i-1] + f[i-2])%10007;
           }
            System.out.println(f[n]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
