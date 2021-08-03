import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String sr ="";
        while(!((sr = sc.next()).equals("0"))){
            StringBuilder sb = new StringBuilder(sr);
            String answer = "no";
            if(sb.toString().equals(sb.reverse().toString())){
                answer = "yes"; 
            }
            System.out.println(answer);
        }
        sc.close();
    }
}
