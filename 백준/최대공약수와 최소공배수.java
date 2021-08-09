import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int num = check(a,b);
        System.out.println(num);
        System.out.println((a*b)/num);
    }

    private static int check(int a, int b){
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        int num = 1;
        while(num>0){
             num = max%min;
             max = min;
             min = num;
        }
        return max;
    }
}
