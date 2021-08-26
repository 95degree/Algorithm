//dfs//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static boolean[][] computers;
    public static boolean[] visited;
    public static int answer = 0;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int k = Integer.parseInt(br.readLine());
            computers = new boolean[n+1][n+1];
            visited = new boolean[n+1];
            for(int i =0; i<k; i++){
                StringTokenizer str = new StringTokenizer(br.readLine());
                int c1 = Integer.parseInt(str.nextToken());
                int c2 = Integer.parseInt(str.nextToken());
                computers[c1][c2] = true;
                computers[c2][c1] = true;
            }
            dfs(1);
            System.out.println(answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dfs(int computer){
        visited[computer] = true;
        for(int i = 1; i<computers[computer].length; i++){
            if(computers[computer][i] && !visited[i]){
                answer++;
                dfs(i);
            }
        }
    }
}

//bfs//
private static void bfs(int computer){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(computer);
        while(!queue.isEmpty()){
            int check = queue.poll();
            visited[check] = true;
            for(int i =0; i<computers[check].length; i++){
                if(computers[check][i] && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                    answer++;
                }
            }
        }
    }
