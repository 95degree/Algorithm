import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sr = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(sr.nextToken());
        int y = Integer.parseInt(sr.nextToken());
        int w = Integer.parseInt(sr.nextToken());
        int h = Integer.parseInt(sr.nextToken());
        int min = Math.min(Math.min(w-x,h-y),Math.min(x,y));
        System.out.print(min);
    }
}
