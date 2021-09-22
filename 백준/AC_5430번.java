import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sr = new StringBuilder();
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                String work = br.readLine();
                br.readLine();
                String array = br.readLine();
                sr.append(move(toDeque(array), work)).append("\n");
            }
            System.out.print(sr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Deque<Integer> toDeque(String array) {
        Deque<Integer> deque = new ArrayDeque<>();
        String split = array.replaceAll("[\\[\\]]", "");
        if(!split.equals("")){
            String[] splitedArray = split.replaceAll(",", " ").split(" ");
            deque = stringToDeque(splitedArray);
        }
        return deque;
    }

    private static Deque<Integer>stringToDeque(String[] splitedArray){
        Deque<Integer>deque = new ArrayDeque<>();
        for(String num : splitedArray){
            deque.add(Integer.parseInt(num));
        }
        return deque;
    }

    private static String move(Deque<Integer> deque, String work) {
        boolean direction = true;
        for (int i = 0; i < work.length(); i++) {
            char ch = work.charAt(i);
            if (ch == 'R') {
                direction = !direction;
            } else {
                if (deque.isEmpty()) {
                    return "error";
                }
                if (direction) {
                   deque.poll();
                } else {
                    deque.pollLast();
                }
            }
        }
        return dequeToString(deque,direction);
    }

    private static String dequeToString(Deque<Integer>deque,boolean direction){
        if(deque.isEmpty()){
            return "[]";
        }
        StringBuilder sr = new StringBuilder("[");
        List<Integer>list = new ArrayList<>(deque);
        if(direction){
            for(int num : list){
                sr.append(num).append(",");
            }
        }
        else{
            for(int i =list.size(); i>0; i--){
                sr.append(list.get(i-1)).append(",");
            }
        }
        return sr.deleteCharAt(sr.length()-1).append("]").toString();
    }
}
