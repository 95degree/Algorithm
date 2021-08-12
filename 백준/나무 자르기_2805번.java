import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(str.nextToken());
            long m = Integer.parseInt(str.nextToken());
            long[] trees = new long[n];
            str = new StringTokenizer(br.readLine());
            long max = 0;
            for(int i =0; i<n; i++){
               long num =Integer.parseInt(str.nextToken());
               trees[i] = num;
               max = Math.max(num,max);
            }
            long left = 0;
            long right = max;
            long mid = 0;
            while(left<=right){
                mid = (left+right)/2;
                long get = 0;
                for(long tree : trees){
                    if(tree<=mid){
                        continue;
                    }
                    get+=tree-mid;
                }
                if(get>=m){
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }
            System.out.println(right);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
