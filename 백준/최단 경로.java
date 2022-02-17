import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sr = new StringBuilder();
    static int v;
    static int e;
    static int[] dist;
    static List<List<Edge>> edges = new ArrayList<>();

    static class Info {
        int idx;
        int dist;

        public Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    static class Edge {
        int to;
        int weight;

        public Edge(int idx, int weight) {
            this.to = idx;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        dist = new int[v];
        int start = Integer.parseInt(br.readLine()) - 1;
        for (int i = 0; i < v; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            edges.get(Integer.parseInt(st.nextToken()) - 1).add(new Edge(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())));
        }

        dijkstra(start);
    }

    static void dijkstra(int start) {
        for(int i = 0; i<v; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;
        PriorityQueue<Info>pq = new PriorityQueue<>(Comparator.comparingInt(o->o.dist));
        pq.add(new Info(start,0));

        while(!pq.isEmpty()){
            Info info = pq.poll();
            if(info.dist>dist[info.idx]) continue;
            for(Edge edge : edges.get(info.idx)){
                int newDist = edge.weight + dist[info.idx];
                if(newDist>= dist[edge.to]) continue;
                dist[edge.to] = newDist;
                pq.add(new Info(edge.to,newDist));
            }
        }
    }

    static void output() {
        for(int num : dist){
            if(num == Integer.MAX_VALUE){
                sr.append("INF");
            } else {
                sr.append(num);
            }
            sr.append("\n");
        }
        System.out.println(sr);
    }
}
