import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static boolean[] visit;

    static class Register {
        public String sr;
        public int num;

        public Register(int num, String sr) {
            this.sr = sr;
            this.num = num;
        }
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder sr = new StringBuilder();
            for (int i = 0; i < n; i++) {
                StringTokenizer str = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(str.nextToken());
                int b = Integer.parseInt(str.nextToken());
                visit = new boolean[10001];
                sr.append(bfs(a, b)).append("\n");
            }
            System.out.println(sr);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String bfs(int a, int b) {
        Queue<Register> queue = new LinkedList<>();
        Register register = new Register(a, "");
        queue.add(register);
        while (!queue.isEmpty()) {
            Register check = queue.poll();
            visit[check.num] = true;
            for (int i = 0; i < 4; i++) {
                int number = check.num;
                String answer = check.sr;
                if (i == 0) {
                    number = workR(number);
                    answer += "R";
                } else if (i == 1) {
                    number = workL(number);
                    answer += "L";
                } else if (i == 2) {
                    number = workD(number);
                    answer += "D";
                } else {
                    number = workS(number);
                    answer += "S";
                }
                if (!visit[number]) {
                    if (number == b) {
                        return answer;
                    }
                    Register newRegister = new Register(number, answer);
                    queue.add(newRegister);
                    visit[number] = true;
                }
            }
        }
        return "";
    }

    private static int workL(int num) {
        num = num % 1000 * 10 + (num / 1000);
        return num;
    }

    private static int workR(int num) {
        num = (num / 10) + (num % 10) * 1000;
        return num;
    }

    private static int workD(int num) {
        return (num * 2) % 10000;
    }

    private static int workS(int num) {
        if (num == 0) {
            return 9999;
        }
        return num - 1;
    }
}
