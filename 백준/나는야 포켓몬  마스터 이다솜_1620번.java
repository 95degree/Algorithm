import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            StringBuilder sr = new StringBuilder();
            int n = Integer.parseInt(str.nextToken());
            int m = Integer.parseInt(str.nextToken());
            Map<Integer, String> poketmons = new HashMap<>();
            Map<String,Integer> poketmonsName = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String name = br.readLine();
                poketmonsName.put(name,i+1);
                poketmons.put(i + 1, name);
            }
            for (int i = 0; i < m; i++) {
                String problem = br.readLine();
                if(isNumber(problem)){
                    sr.append(poketmons.get(Integer.parseInt(problem))).append("\n");
                }
                else{
                    sr.append(poketmonsName.get(problem)).append("\n");
                }
            }
            
            System.out.println(sr.toString());

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isNumber(String problem){
        char[] string = problem.toCharArray();
        int check = 0;
        for(char ch : string){
            if(Character.isDigit(ch)){
                check++;
            }
        }
        return problem.length() == check;
    }
}
