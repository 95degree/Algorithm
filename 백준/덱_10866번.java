import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Deque {

        private List<Integer> list;

        public Deque() {
            list = new ArrayList<>();
        }

        public void push_front(int num) {
            list.add(0, num);
        }

        public void push_back(int num) {
            list.add(num);
        }

        public int pop_front() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.remove(0);
        }

        public int pop_back() {
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

        public int front() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.get(0);
        }

        public int back() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            Deque deque = new Deque();
            StringBuilder sr = new StringBuilder();
            for (int i = 0; i < n; i++) {
                String method = br.readLine();
                if (method.contains("push_front")) {
                    String[] str = method.split(" ");
                    deque.push_front(Integer.parseInt(str[1]));
                } else if (method.contains("push_back")) {
                    String[] str = method.split(" ");
                    deque.push_back(Integer.parseInt(str[1]));
                } else if (method.equals("pop_front")) {
                    sr.append(appendNewLine(deque.pop_front()));
                } else if (method.equals("pop_back")) {
                    sr.append(appendNewLine(deque.pop_back()));
                } else if (method.equals("size")) {
                    sr.append(appendNewLine(deque.size()));
                } else if (method.equals("empty")) {
                    sr.append(appendNewLine(deque.empty()));
                } else if (method.equals("front")) {
                    sr.append(appendNewLine(deque.front()));
                } else {
                    sr.append(appendNewLine(deque.back()));
                }
            }
            System.out.println(sr);
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

    private static StringBuilder appendNewLine(int num) {
        StringBuilder str = new StringBuilder();
        return str.append(num).append("\n");
    }
}
