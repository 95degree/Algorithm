import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int r;
    static int c;
    static int answer = 0;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(str.nextToken());
            r = Integer.parseInt(str.nextToken());
            c = Integer.parseInt(str.nextToken());
            find(0,0,(int)Math.pow(2,n));
            System.out.println(answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void find(int startY, int startX, int n){
        n/=2;
        int sum = (int)Math.pow(n,2);
        if(startY == r && startX == c){
            return;
        }
        //제1사분면//
        else if(startY<= r && r< startY+n && startX<=c && c<startX +n){
            find(startY,startX,n);
        }
        //제2사분면//
        else if(startY<= r && r< startY+n && startX+n<=c){
            answer+=sum;
            find(startY,startX+n,n);

        }
        //제3사분면//
        else if(startY+n <= r && startX<=c && c<startX +n){
            answer+=sum*2;
            find(startY+n,startX,n);

        }
        //제4사분면//
        else{
            answer+=sum*3;
            find(startY+n,startX+n,n);
        }
    }
}
