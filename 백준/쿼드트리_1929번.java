import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] map;
    private static StringBuilder sr = new StringBuilder();

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            for(int i =0; i<n; i++){
                String line = br.readLine();
                for(int j =0; j<n; j++){
                    map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
                }
            }
            zip(0,0,n);
            System.out.println(sr);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void zip(int startY, int startX, int length){
        if(check(startY,startX,length)){
            sr.append(map[startY][startX]);
            return;
        }
        int newLength = length/2;
        sr.append("(");
        for(int i =0; i<2; i++){
            for(int j =0; j<2; j++){
                zip(startY+i*newLength,startX+j*newLength,newLength);
            }
        }
        sr.append(")");
    }

    private static boolean check(int startY, int startX, int length){
        int num = map[startY][startX];
        for(int i = startY; i<startY+length; i++){
            for(int j = startX; j<startX+length; j++){
                if(num!= map[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
