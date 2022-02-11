import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sr = new StringBuilder();
    static int n;
    static int[] a;
    static int[] b;
    static int count;


    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int aLength = Integer.parseInt(st.nextToken());
            int bLength = Integer.parseInt(st.nextToken());

            a = getArray(aLength, br.readLine());
            b = getArray(bLength, br.readLine());
            find();
        }
    }

    static int[] getArray(int length, String s) {
        StringTokenizer st = new StringTokenizer(s);
        int[] array = new int[length+1];
        for (int i = 0; i < length; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        return array;
    }

    static void find() {
        count = 0;
        for (int j : a) {
            count += search(j);
        }
        sr.append(count).append("\n");
    }

    static int search(int num) {
        int left = 0;
        int right = b.length-1;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (num <= b[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
                answer = mid;
            }
        }
        return answer;
    }

    static void output() {
        System.out.println(sr);
    }
}
