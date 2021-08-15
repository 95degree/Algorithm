import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder sr = new StringBuilder();
            for (int i = 0; i < n; i++) {
                char[] array = br.readLine().toCharArray();
                Stack<Character> stack = new Stack<>();
                String answer = "NO";
                for (char check : array) {
                    if (stack.isEmpty()) {
                        stack.push(check);
                        continue;
                    }
                    if (check == ')' && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(check);
                    }
                }
                if (stack.isEmpty()) {
                    answer = "YES";
                }
                sr.append(answer).append("\n");
            }
            System.out.println(sr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    
