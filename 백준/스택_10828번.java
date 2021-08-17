import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Stack {

        private List<Integer> list;

        public Stack() {
            list = new ArrayList<>();
        }

        public void push(int num) {
            list.add(num);
        }

        public int pop() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.remove(list.size() - 1);
        }

        public int size() {
            return list.size();
        }

        public int empty() {
            if (list.isEmpty()) {
                return 1;
            }
            return 0;
        }

        public int top() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            Stack stack = new Stack();
            StringBuilder sr = new StringBuilder();
            for (int i = 0; i < n; i++) {
                String method = br.readLine();
                if (method.contains("push")) {
                    String[] str = method.split(" ");
                    stack.push(Integer.parseInt(str[1]));
                } else if (method.equals("pop")) {
                    sr.append(appendNewLine(stack.pop()));
                } else if (method.equals("size")) {
                    sr.append(appendNewLine(stack.size()));
                } else if (method.equals("empty")) {
                    sr.append(appendNewLine(stack.empty()));
                } else {
                    sr.append(appendNewLine(stack.top()));
                }
            }
            System.out.println(sr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static StringBuilder appendNewLine(int num) {
        StringBuilder str = new StringBuilder();
        return str.append(num).append("\n");
    }
}
