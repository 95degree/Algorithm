import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer>queue = new LinkedList<>();
        for(int i =1; i<=n; i++){
            queue.add(i);
        }
        int answer = 0;
        while(true){
            answer = queue.poll();
            if(queue.isEmpty()){
                break;
            }
            queue.add(queue.poll());
        }
        System.out.println(answer);
    }
}
