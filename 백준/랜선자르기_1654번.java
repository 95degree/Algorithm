import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        long n = sc.nextLong();
        int[] ramps = new int[k];
        for(int i =0; i<k; i++){
            ramps[i] = sc.nextInt();
        }
        Arrays.sort(ramps);
        long max = ramps[ramps.length-1];
        long min = 1;

        while(min<=max){
            long count = 0;
            long mid = (max+min)/2;
            for(long ramp : ramps){
                count += ramp/mid;
            }
            if(count>=n){
                min = mid+1;
            }
            else{
                max = mid-1;
            }
        }
        System.out.println(max);
    }
}
