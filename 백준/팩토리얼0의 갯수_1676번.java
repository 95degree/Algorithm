import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int five = 0;
            int two = 0;
            for(int i =1; i<=n; i++){
                int num = i;
                while(num%2 == 0){
                    num/=2;
                    two++;
                }
                while(num%5 ==0){
                    num/=5;
                    five++;
                }
            }
            System.out.println(Math.min(five,two));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
