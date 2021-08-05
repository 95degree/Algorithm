import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] n = createArray(br);
        Arrays.sort(n);
        int[] m = createArray(br);
        for(int num : m){
            if(check(n,num)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
    private static int[] createArray(BufferedReader br) throws IOException {
        int num = Integer.parseInt(br.readLine());
        StringTokenizer sr = new StringTokenizer(br.readLine());
        int[] array = new int[num];
        for(int i =0; i<array.length; i++){
            array[i] = Integer.parseInt(sr.nextToken());
        }
        return array;
    }

    private static boolean check(int[] n, int num){
        int left = 0;
        int right = n.length-1;
        int mid = 0;
        boolean bool = false;
        while(left<=right){
            mid = (left+right)/2;
            if(n[mid]>num){
                right = mid-1;
            }
            else if(n[mid] < num){
                left = mid+1;
            }
            else{
                bool = true;
                break;
            }
        }
        return bool;
    }
}
