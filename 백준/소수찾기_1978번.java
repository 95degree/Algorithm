import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        for(int i =0; i<n; i++){
            int check = Integer.parseInt(st.nextToken());
            if(check == 1){
                continue;
            }
            boolean prime = false;
            for(int j=2; j<=Math.sqrt(check); j++){
                if(check%j == 0){
                    prime = true;
                    break;
                }
            }
            if(!prime){
                answer++;
            }
        }
        System.out.println(answer);
    }
}
