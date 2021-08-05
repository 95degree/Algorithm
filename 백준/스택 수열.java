import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for(int i =0; i<n; i++){
            array[i] = sc.nextInt();
        }
        List<String>list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int index =0;
        int num =1;
        while(num<=n){
            if(stack.isEmpty() || num<=n){
                stack.push(num++);
                list.add("+");
            }
            while(stack.peek() == array[index]){
                stack.pop();
                index++;
                list.add("-");
                if(stack.isEmpty()){
                    break;
                }
            }
        }
        if(!stack.isEmpty()){
            list.clear();
            list.add("NO");
        }
        for(String answer : list){
            System.out.println(answer);
        }
    }
}
