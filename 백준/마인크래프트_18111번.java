import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(str.nextToken());
            int m = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            int[] array = new int[n*m];
            int min = 256;
            int max = 0;
            for(int i =0; i<n; i++){
                str = new StringTokenizer(br.readLine());
                for(int j =0; j<m; j++){
                    int now = Integer.parseInt(str.nextToken());
                    array[i*m+j] = now;
                    min = Math.min(min,now);
                    max = Math.max(max,now);
                }
            }
            int[] minWork = new int[2];
            minWork[0] = n*m*256*2;
            for(int i = min; i<=max; i++){
                int time = 0;
                int inventory = b;
                for(int height : array){
                    int block;
                    if(height<i){
                        block = i-height;
                        inventory -= block;
                        time += block;
                    }
                    else{
                        block = height-i;
                        inventory += block;
                        time += block*2;
                    }
                }
                if(inventory>=0 && minWork[0]>=time){
                    minWork[0] = time;
                    minWork[1] = i;
                }
            }
            System.out.println(minWork[0] +" "+minWork[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
