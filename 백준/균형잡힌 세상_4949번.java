import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String str;
            StringBuilder sr = new StringBuilder();
            while (!(str= br.readLine()).equals(".")) {
                char[] array = str.toCharArray();
                Stack<Character> stack = new Stack<>();
                for (char ch : array) {
                    if (ch == '(' || ch == '[' || ch == ')' || ch == ']') {
                        if (stack.isEmpty()) {
                            stack.push(ch);
                            continue;
                        }
                        if ((stack.peek() == '(' && ch == ')') || (stack.peek() == '[' && ch == ']')) {
                            stack.pop();
                        } else {
                            stack.push(ch);
                        }
                    }
                }
                if (stack.isEmpty()) {
                    sr.append("yes").append("\n");
                } else {
                    sr.append("no").append("\n");
                }
            }
            System.out.println(sr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
