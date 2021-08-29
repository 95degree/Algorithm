//문제의 핵심은 -가 나온 첫시점부터 뒤에 나오는 모든 숫자를 더하는 것이다. -가 나온 시점부터는 -가 오든 +가 오든 괄호를 쳐서 -하도록 만들수가 있기 때문이다.//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String formula = br.readLine().replaceAll("[+]"," ").replaceAll("[-]", " -");
            List<Integer>list = new ArrayList<>();
            int answer = 0;
            boolean check = false;
            StringTokenizer str = new StringTokenizer(formula);
            while(str.hasMoreTokens()){
                list.add(Integer.parseInt(str.nextToken()));
            }
            for(int num : list){
                if(num<0 && !check){
                    check = true;
                    answer+=num;
                    continue;
                }
                if(!check){
                    answer+=num;
                }
                else if(num<0){
                    answer+=num;
                }
                else{
                    answer-=num;
                }
            }
            System.out.println(answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//더 깔끔하게 풀기//
//-로 split하고 처음 항은 +를 없에고 합을 구해 answer에 넣어주고 나머지 항들은 구한 후에 answer에 -해준다.//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String formula = br.readLine();
            String[] split = formula.split("-");
            int answer = sum(split[0]);
            for(int i =1; i< split.length; i++){
                answer -= sum(split[i]);
            }
            System.out.println(answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static int sum(String formula){
        int sum = 0;
        formula = formula.replaceAll("[+]"," ");
        String[] split = formula.split(" ");
        for(String num : split){
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}
