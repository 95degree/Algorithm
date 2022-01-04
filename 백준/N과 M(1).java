import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sr = new StringBuilder();
    static int n;
    static int m;
    static int[] array;
    static boolean[] check;

    static String input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(input());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[m];
        check = new boolean[n+1];
        recursive(0);
        System.out.println(sr.toString());
    }

    public static void recursive(int k){
        if(k==m){
            for (int i : array) {
                sr.append(i).append(" ");
            }
            sr.append("\n");
        } else {
            for(int i = 1; i<=n; i++){
                if(!check[i]){
                    array[k] = i;
                    check[i] = true;
                    recursive(k+1);
                    check[i] = false;
                }
            }
        }
    }
}
