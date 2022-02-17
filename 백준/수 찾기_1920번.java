import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sr = new StringBuilder();
    static int n;
    static int[] w;
    static int m;
    static int[] p;

    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        w = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        p = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(w);
        for (int num : p) {
            sr.append(twoPointer(num)).append("\n");
        }
    }

    static int twoPointer(int target) {
        int left = 0;
        int right = n-1;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (w[mid] <= target) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }
        return w[answer] == target ? 1 : 0;
    }

    static void output() {
        System.out.println(sr);
    }
}


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
