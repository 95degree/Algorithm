import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int y = input.charAt(0) - 'a' + 1;
        int x = input.charAt(1) - '0';
        int[][] moves = {{1, -2}, {1, 2}, {2, 1}, {2, -1}, {-1, -2}, {-1, 2}, {-2, 1}, {-2, -1}};
        int check =0;
        for(int[] move : moves){
            if(move[0]+y >=1 && move[0]+y<=8 && move[1]+x>=1 &&move[1]+x<=8){
                check++;
            }
        }
        System.out.println(check);
        sc.close();
    }
}
