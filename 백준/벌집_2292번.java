import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int check = 1;
        int x = 1;
        while(x<n){
            x += 6*check++;
        }
        System.out.println(check);
    }
}
