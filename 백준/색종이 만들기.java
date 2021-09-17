import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] map;
    static int[] answer;
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n  = Integer.parseInt(br.readLine());
            map = new int[n][n];
            for(int i =0; i<n; i++){
                StringTokenizer str = new StringTokenizer(br.readLine());
                for(int j =0; j<n; j++){
                    map[i][j] = Integer.parseInt(str.nextToken());
                }
            }
            answer = new int[2];
            cut(0,0,n);
            System.out.println(answer[0]+"\n"+answer[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean check(int y, int x, int idx){
        int first = map[y][x];
        for(int i = y; i<y+idx; i++){
            for(int j = x; j<x+idx; j++){
                if(map[i][j] != first){
                    return false;
                }
            }
        }
        return true;
    }

    private static void cut(int y, int x, int idx){
        if(check(y,x,idx)){
            answer[map[y][x]]++;
            return;
        }
        idx /= 2;
        for(int i =0 ; i<2; i++){
            for(int j =0; j<2; j++){
                cut(i*idx+y,j*idx+x,idx);
            }
        }
    }
}
