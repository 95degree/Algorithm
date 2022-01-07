import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sr = new StringBuilder();
    static int n;
    static Student[] board;

    static class Student implements Comparable<Student> {
        int korean;
        int english;
        int math;
        String name;

        public Student(String string) {
            StringTokenizer sr = new StringTokenizer(string);
            this.name = sr.nextToken();
            this.korean = Integer.parseInt(sr.nextToken());
            this.english = Integer.parseInt(sr.nextToken());
            this.math = Integer.parseInt(sr.nextToken());
        }

        @Override
        public int compareTo(Student o) {
            if (korean != o.korean) {
                return o.korean - korean;
            }
            if (english != o.english) {
                return english - o.english;
            }
            if (math != o.math) {
                return o.math - math;
            }
            return name.compareTo(o.name);
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new Student[n];
        for (int i = 0; i < n; i++) {
            board[i] = new Student(br.readLine());
        }

    }

    static void output() {
        for (Student student : board) {
            sr.append(student.name).append("\n");
        }
        System.out.println(sr.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(board);
        output();
    }
}
