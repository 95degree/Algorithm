import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sr = new StringBuilder();
    static int n;
    static int[] dist;
    static List<List<Edge>> edges;
    static int m;

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

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[n];
        edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            edges.get(Integer.parseInt(st.nextToken()) - 1).add(new Edge(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        dijkstra(Integer.parseInt(st.nextToken()));
        System.out.println(dist[Integer.parseInt(st.nextToken()) - 1]);
    }

    static void dijkstra(int start) {

        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        pq.add(new Info(start - 1, 0));
        dist[start - 1] = 0;

        while (!pq.isEmpty()) {
            Info info = pq.poll();
            if (dist[info.idx] < info.dist) continue;
            for (Edge edge : edges.get(info.idx)) {
                int distWeight = dist[info.idx] + edge.weight;
                if (distWeight >= dist[edge.to]) continue;
                dist[edge.to] = distWeight;
                pq.add(new Info(edge.to, dist[edge.to]));
            }
        }
    }

    static void output() {
        System.out.println(sr);
    }
}
