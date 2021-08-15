//문자열로 풀기//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(br.readLine());
            StringBuilder answer = new StringBuilder();
            for(int i =0; i<count; i++){
                StringBuilder sr = new StringBuilder();
                StringTokenizer str = new StringTokenizer(br.readLine());
                int h = Integer.parseInt(str.nextToken());
                int w = Integer.parseInt(str.nextToken());
                int n = Integer.parseInt(str.nextToken());
                int roomNumber = n/h;
                int stair = n%h;
                if(stair != 0){
                    roomNumber++;
                }
                else{
                    stair = h;
                }
                sr.append(stair);
                if(roomNumber<10){
                    sr.append(0);
                }
                sr.append(roomNumber);
                answer.append(sr).append("\n");
            }
            System.out.println(answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//숫자로 풀기//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(br.readLine());
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < count; i++) {
                StringTokenizer str = new StringTokenizer(br.readLine());
                int h = Integer.parseInt(str.nextToken());
                int w = Integer.parseInt(str.nextToken());
                int n = Integer.parseInt(str.nextToken());
                int roomNumber = n / h;
                int stair = n % h;

                if (stair == 0) {
                    answer.append(h*100 + roomNumber).append("\n");
                } else {
                    answer.append(stair*100+roomNumber+1).append("\n");
                }
            }
            System.out.println(answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
