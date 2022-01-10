//음 자꾸 최댓값 구하는 부분을 sort하고 제일 끝 원소를 가져오면 틀렸다고 나온다...... 그래서 찾아보니 그냥 for문 돌면서 max를 찾더라. 그래서해보니 된다. 이거 왜이래 ㅋㅋㅋㅋㅋ//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    static StringBuilder sr = new StringBuilder();
    static int n;
    static int m;
    static int[] x;

    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        x = new int[n + 1];
        for (int i = 0; i < n; i++) {
            x[i + 1] = sc.nextInt();
        }
    }

    static void output() {
        System.out.println(search());
    }

    static int search() {
        int left = x[1];
        int right = 1000000000;
        for(int i =1; i<=n; i++){
            left = Math.max(left,x[i]);
        }
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid)) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }

    static boolean check(int k) {
        int count = 1;
        int nowMoney = 0;
        for (int i = 1; i < n + 1; i++) {
            if (nowMoney + x[i] > k) {
                count++;
                nowMoney = x[i];
            } else {
                nowMoney += x[i];
            }
        }
        return count <= m;
    }
}
