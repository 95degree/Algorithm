import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int[][] triangle = new int[n][n];
            for(int i = 0; i<n; i++){
                StringTokenizer str = new StringTokenizer(br.readLine());
                for(int j =0; j<n; j++){
                    if(str.hasMoreTokens()){
                        triangle[i][j] = Integer.parseInt(str.nextToken());
                        continue;
                    }
                    triangle[i][j] = -1;
                }
            }

            for(int i = 1; i<n; i++){
                for(int j =0; j<n; j++){
                    triangle[i][j] += max(triangle[i-1],j);
                }
            }

            Arrays.sort(triangle[n-1]);
            System.out.println(triangle[n-1][n-1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int max(int[] array, int idx){
        int max = -1;
        for(int i = 0; i<array.length; i++){
            if((i==idx || i==idx-1) && max<array[i]){
                max = array[i];
            }
        }
        return max;
    }
}
