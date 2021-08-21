public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(str.nextToken());
            int k = Integer.parseInt(str.nextToken());
            Queue<Integer>queue = new LinkedList<>();
            StringBuilder sr = new StringBuilder("<");
            for(int i =0; i<n; i++){
                queue.add(i+1);
            }
            while(queue.size()!=1){
                for(int i =1; i<k; i++){
                    int num = queue.poll();
                    queue.add(num);
                }
                sr.append(queue.poll()).append(", ");
            }
            sr.append(queue.poll()).append(">");
            System.out.println(sr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
