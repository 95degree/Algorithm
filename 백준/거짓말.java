import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static StringBuilder sr = new StringBuilder();
    static int n;
    static int m;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }
        m = sc.nextInt();
        int p = sc.nextInt();
        int[] truePeople = new int[p];
        for (int i = 0; i < p; i++) {
            truePeople[i] = sc.nextInt();
            union(truePeople[0], truePeople[i]);
        }

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int count = sc.nextInt();
            int[] party = new int[count];
            for (int j = 0; j < count; j++) {
                party[j] = sc.nextInt();
                union(party[0], party[j]);
            }
            list.add(party);
        }

        for (int[] party : list) {
            for (int people : party) {
                if (p > 0 && find(people) == find(truePeople[0])) {
                    m--;
                    break;
                }
            }
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    static void output() {
        System.out.println(m);
    }
}
