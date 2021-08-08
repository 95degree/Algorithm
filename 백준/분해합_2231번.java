import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer>list = new ArrayList<>();
        for (int i = n; i>0; i--) {
            int answer = 0;
            int check = i;
            int num = 1;
            while(num >0){
                answer+= check%10;
                num = check/=10;
            }
            if(answer+i == n){
                list.add(i);
            }
        }
        int check = 0;
        if(list.size()>0){
            Collections.sort(list);
            check = list.get(0);
        }
        System.out.println(check);
    }
}
