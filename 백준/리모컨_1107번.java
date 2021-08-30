//이상한 문제 다른 사람들이 본걸 보고 풀어본거다. 찾고자 하는 채널은 500000까지인데 tv채널은 몇까지 만들수 있는지 안 적혀있다. 그리고 중간 중간 안되는 경우의 수가 너무 많다.//
import java.util.*;

public class Main {
    private static boolean[] nums = new boolean[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            nums[sc.nextInt()] = true;
        }
        int answer = Math.abs(n - 100);
        for (int i = 0; i < 1000000; i++) {
            int check = checkTest(i);
            if (check > 0) {
                int num = Math.abs(n - i);
                answer = Math.min(answer, num + check);
            }
        }
        System.out.println(answer);
    }

    private static int checkTest(int num) {
        if (num == 0) {
            if (nums[0]) {
                return 0;
            }
            return 1;
        }
        int answer = 0;
        while (num > 0) {
            if (nums[num % 10]) {
                return 0;
            }
            answer++;
            num /= 10;
        }
        return answer;
    }
}
