import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int answer = 666;
        int count = 0;
        while(count!=num){
            if(String.valueOf(answer).contains("666")){
                count++;
            }
            answer++;
        }
        System.out.print(answer-1);
    }
}
