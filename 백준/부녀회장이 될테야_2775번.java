import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sr = new StringBuilder();
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                int stair = Integer.parseInt(br.readLine());
                int x = Integer.parseInt(br.readLine());
                int[] array = new int[x + 1];
                for (int j = 0; j < x + 1; j++) {
                    array[j] = j;
                }
                sr.append(check(array, stair)).append("\n");
            }
            System.out.println(sr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int check(int[] array, int stair) {
        int[] tmp = array;
        int[] array2 = new int[array.length];
        for (int i = 1; i <= stair; i++) {
            for (int j = 1; j < array.length; j++) {
                array2[j] = array2[j-1] + tmp[j];
            }
            tmp = array2;
        }
        return tmp[tmp.length-1];
    }
}
