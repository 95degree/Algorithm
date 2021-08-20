import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            String[] array = new String[n];
            StringBuilder sr = new StringBuilder();
            for (int i = 0; i <n; i++){
                array[i] = br.readLine();
            }
            Arrays.sort(array,(o1,o2) -> {
                StringTokenizer str = new StringTokenizer(o1);
                int x1 = Integer.parseInt(str.nextToken());
                int y1 = Integer.parseInt(str.nextToken());
                str = new StringTokenizer(o2);
                int x2 = Integer.parseInt(str.nextToken());
                int y2 = Integer.parseInt(str.nextToken());
                if(y1==y2){
                    return x1-x2;
                }
                return y1-y2;
            });
            for(String str : array){
                sr.append(str).append("\n");
            }
            System.out.println(sr);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//더 효율적으로 풀기//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int[][] array = new int[n][2];
            StringBuilder sr = new StringBuilder();
            for (int i = 0; i < n; i++) {
                StringTokenizer str = new StringTokenizer(br.readLine());
                array[i][0] = Integer.parseInt(str.nextToken());
                array[i][1] = Integer.parseInt(str.nextToken());
            }
            Arrays.sort(array, (o1, o2) -> {
                if(o1[1]==o2[1]){
                    return o1[0]-o2[0];
                }
                return o1[1] - o2[1];

            });
            for (int[] xy : array) {
                sr.append(xy[0]).append(" ").append(xy[1]).append("\n");
            }
            System.out.println(sr);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//수를 사용해서 풀기   최솟값이 -100000이니까 모든 x y에 100000을 더해 정수로 만들어주고 먼저 기준이 되는 y에 100000에 10을 곱한 1000000을 곱하고 x를 더한다.
//이렇게 하면 수가 만약 x가 10이고 y가 5면 (1,000,000 * 100,005) + 100,010   100,005,100,010이 된다. 이 수를 다시 1,000,000를 기준으로 몫과 나머지로 y x를 구할 수가 있다.
//간단하게  x y의 최대값에 *10값을 곱해서 하면 되는거다. 그래야 x y과 최대값을 기준으로 딱 나눠진다. 위에서 100,000을 기준으로 100,005 와 100,010으로 나눠지는것 처럼말이다.//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder sr = new StringBuilder();
            long[] array = new long[n];
            int num = 100000;
            for(int i =0; i<n; i++){
                StringTokenizer str = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(str.nextToken()) + num;
                int y = Integer.parseInt(str.nextToken()) + num;
                array[i] = y* 1000000L + x;
            }
            Arrays.sort(array);
            for(long number : array){
                sr.append(number%(num*10) - num).append(" ").append(number/(num*10) - num).append("\n");
            }
            System.out.println(sr);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

