import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sr = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] array = new int[n];
            for(int i =0; i<n; i++){
                array[i] = Integer.parseInt(st.nextToken());
            }
            System.out.println(maxM(array,m));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static int maxM(int[] array, int m){
        int maxNum = 0;
        for(int i =0; i< array.length-2; i++){
            for(int j = i+1; j<array.length-1; j++){
                for(int k = j+1; k<array.length; k++){
                    int num = array[i] + array[j] + array[k];
                    if(num<=m){
                        maxNum = Math.max(maxNum,num);
                    }
                }
            }
        }
        return maxNum;
    }
}
