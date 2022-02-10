import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sr = new StringBuilder();
    static int n;
    static int m;
    static List<List<Integer>> list = new ArrayList<>();
    static int[] answer;

    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = new int[n];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        st = new StringTokenizer(br.readLine());
        st.nextToken();
        for(int i =2; i<=n; i++){
            int par = Integer.parseInt(st.nextToken());
            list.get(par).add(i);
        }

        for(int i =0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            answer[Integer.parseInt(st.nextToken())-1] += Integer.parseInt(st.nextToken());
        }
        dfs(1);
    }

    static void dfs(int idx) {
        for(int node : list.get(idx)){
            answer[node-1] += answer[idx-1];
            dfs(node);
        }
    }

    static void output() {
        for(int num : answer){
            sr.append(num).append(" ");
        }
        System.out.println(sr);
    }
}
