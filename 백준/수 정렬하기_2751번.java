BufferedReader + Countin sort
import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sr = new StringBuilder();
        int n = sc.nextInt();
        boolean[] array = new boolean[2000001];
        for(int i =0; i<n; i++){
            array[sc.nextInt()+1000000] = true;
        }
        for(int i =0; i< array.length; i++){
            if(array[i]){
                sr.append(i-1000000).append("\n");
            }
        }
        System.out.println(sr);
        sc.close();
    }
}
BufferReader + Collections.sort()
import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sr = new StringBuilder();
        int n = sc.nextInt();
        List<Integer>list = new ArrayList<>();
        for(int i =0; i<n; i++){
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        for(int num : list){
            sr.append(num).append("\n");
        }
        System.out.println(sr);
        sc.close();
    }
}
