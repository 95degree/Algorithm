//너무 어려워서 결국 어떻게 풀었는지 보고 풀었다.  일단 1~4사분면이 어떻게 나눠지는지 파악하고   r, c가 어느 사분면에 위치해 있는지 알아내고 그걸 다시 범위를 줄이는 식으로 해나가면서 풀면 된다.//
//그리고 결국 n값이 1이 되면 정확히 r c에 위치해 있는다//

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
