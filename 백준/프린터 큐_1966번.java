//이너클래스로 구현//
import java.util.*;
import java.io.*;

public class Main {
    public static class Node {
        public int index;
        public int number;

        public Node(int number, int index) {
            this.index = index;
            this.number = number;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        StringBuilder sr = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int answer =0;
            Queue<Node> queue = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int check = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < length; j++) {
                int num = Integer.parseInt(st.nextToken());
                queue.add(new Node(num, j));
                list.add(num);
            }
            list.sort(Collections.reverseOrder());
            while (true) {
                Node print = queue.poll();
                if (list.get(0) == print.number){
                    if(print.index == check){
                        answer++;
                        break;
                    }
                    list.remove(0);
                    answer++;
                }
                else{
                    queue.add(print);
                }
            }
            sr.append(answer).append("\n");
        }
        System.out.print(sr);
    }
}

//이너클래스 없이 구현//
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        Queue<String> queue = new LinkedList<>();
        StringBuilder sr = new StringBuilder();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int check = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int number = 1;
            String findPrint ="";
            for (int j = 0; j < length; j++) {
                String num = st.nextToken();
                if(queue.contains(num)){
                    num += Integer.toString(number++);
                }
                if(j==check){
                    findPrint = num;
                }
                queue.add(num);
            }
            System.out.println(find(queue,findPrint));
            queue.clear();
        }
    }

    private static int find(Queue<String> queue, String check) {
        String peek = "";
        int answer =0;
        while(!peek.equals(check)){
            String print = queue.poll();
            if(queue.isEmpty()){
                answer++;
                break;
            }
            Iterator<String> iterator = queue.iterator();
            char chr = print.charAt(0);
            boolean bool = false;
            while(iterator.hasNext()){
                if(chr<iterator.next().charAt(0)){
                    bool = true;
                    break;
                }
            }
            if(bool){
                queue.add(print);
            }
            else{
                peek = print;
                answer++;
            }
        }
        return answer;
    }
}
