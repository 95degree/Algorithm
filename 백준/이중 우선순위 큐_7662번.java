//TreeMap으로 품 TreeMap은 최소 key값과 최대 key값을 가져올수 있다.//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder sr = new StringBuilder();
            for (int i = 0; i < n; i++) {
                int k = Integer.parseInt(br.readLine());
                TreeMap<Integer, Integer> treeMap = new TreeMap<>();
                for (int j = 0; j < k; j++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    String calculation = st.nextToken();
                    int num = Integer.parseInt(st.nextToken());
                    if ("I".equals(calculation)) {
                        treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
                    } else {
                        if (!treeMap.isEmpty()) {
                            if (num == 1) {
                                int lastKey = treeMap.lastKey();
                                remove(treeMap, lastKey);
                            } else {
                                int firstKey = treeMap.firstKey();
                                remove(treeMap, firstKey);
                            }
                        }
                    }
                }
                if (treeMap.isEmpty()) {
                    sr.append("EMPTY").append("\n");
                    continue;
                }
                sr.append(result(treeMap)).append("\n");
            }
            System.out.println(sr);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    private static void remove(Map<Integer, Integer> map, int key) {
        int count = map.get(key);
        if (count == 1) {
            map.remove(key);
            return;
        }
        map.put(key, count - 1);
    }

    private static StringBuilder result(TreeMap<Integer, Integer> map) {
        StringBuilder sr = new StringBuilder();
        int firstKey = map.firstKey();
        int lastKey = map.lastKey();
        return sr.append(lastKey).append(" ").append(firstKey);
    }
}
