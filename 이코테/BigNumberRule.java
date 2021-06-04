import java.util.ArrayList;
import java.util.Collections;

public class BigNumberRule {
    public static int solution(int n, int m, int k, int[] numList) {
        int answer = 0;
        ArrayList<Integer> numArray = new ArrayList<>();
        int firstMax, secondMax;
        for (int num : numList) {
            numArray.add(num);
        }
        Collections.sort(numArray);
        firstMax = numArray.get(n - 1);
        secondMax = numArray.get(n - 2);
        int count = (m / (k + 1)) * k;
        count += m % (k + 1);
        answer = count * firstMax;
        answer += (m - count) * secondMax;
        return answer;
    }

    public static void main(String[] args) {
        int[] list = {2, 4, 5, 4, 6};
        System.out.println(solution(5, 8, 3, list));
    }
}
