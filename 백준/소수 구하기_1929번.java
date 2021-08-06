import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int answer = 0;
        boolean[] check = new boolean[n+1];
        for(int i = 2; i<=Math.sqrt(n); i++){
            if(!check[i]){
                for(int j = 2; i*j<check.length; j++){
                    check[i*j] = true;
                }
            }
        }
        for(int i = m; i<=n; i++){
            if(i!=0&&i!=1&& !check[i]){
                System.out.println(i);
            }
        }
    }
}

//에라토스테네스의 체 좀 더 이쁘게 쓰기//
 for(int i=2; i<=m; i++) {
        	if(prime[i]) continue;
        	
        	if(i >= n) sb.append(i+"\n");
        	
        	for(int j=i+i; j<=m; j+=i) {
        		prime[j] = true;
        	}
        }
