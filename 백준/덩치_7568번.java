import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class People {
        
        public int weight;
        public int height;
        public int rank = 1;

        public People(String string) {
            StringTokenizer str = new StringTokenizer(string);
            weight = Integer.parseInt(str.nextToken());
            height = Integer.parseInt(str.nextToken());
        }

        public void compare(People people) {
            int peopleWeight = people.weight;
            int peopleHeight = people.height;
            if (weight < peopleWeight && height < peopleHeight) {
                rank++;
            }
        }
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            List<People> list = new ArrayList<>();
            StringBuilder sr = new StringBuilder();
            for (int i = 0; i < n; i++) {
                list.add(new People(br.readLine()));
            }
            for (People people : list) {
                for (People comparePeople : list) {
                    people.compare(comparePeople);
                }
            }
            for (People people : list) {
                sr.append(people.rank).append(" ");
            }
            System.out.println(sr);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
