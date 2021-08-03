import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str ="";
        int length = scanner.nextInt();
        Set<String> set = new TreeSet<>();
        for(int i =0; i<length; i++){
            set.add(scanner.next());
        }
        List<String>list = new ArrayList<>(set);
        list.sort((s1, s2) -> {
            if (s1.length() == s2.length()) {
                return s1.compareTo(s2);
            }
            return s1.length() - s2.length();
        });
        for(String sr : list){
            System.out.println(sr);
        }
    }
}
