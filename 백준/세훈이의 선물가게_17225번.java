//선물을 이미 포장해야 할것이 있으면 동시에 포장하는 것이라 포장이 끝나는 시간부터 이어서 포장을 진행해야 한다.//
//그래서 항상 maxTime을 체크하고 현재 주문이 들어온 시간이 maxTime보다 크면 그냥 주문 시간을 넣고 maxTime을 주문시간 + 포장시간이 된다. 
//주문시간이 maxTime보다 작으면 포장을 이어서 하기 때문에 maxTime을 넣고 maxTime에 포장시간을 더한 시간이 maxTime이 되도록 한다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int[] check = new int[3];
            List<Integer> p1 = new ArrayList<>();
            List<Integer> p2 = new ArrayList<>();
            Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            });

            for (int i = 0; i < 3; i++) {
                check[i] = Integer.parseInt(str.nextToken());
            }
            int p1MaxTime = 0;
            int p2MaxTime = 0;
            for (int i = 0; i < check[2]; i++) {
                str = new StringTokenizer(br.readLine());
                int time = Integer.parseInt(str.nextToken());
                int color = str.nextToken().equals("B") ? 0 : 1;
                int num = Integer.parseInt(str.nextToken());
                for (int j = 0; j < num; j++) {
                    int[] work = new int[2];
                    work[0] = color;
                    if(color==0) {
                        if(p1MaxTime<time){
                            work[1] = time;
                            p1MaxTime = time + check[0];
                        }
                        else{
                            work[1] = p1MaxTime;
                            p1MaxTime += check[0];
                        }

                    }
                    else{
                        if(p2MaxTime<time){
                            work[1] = time;
                            p2MaxTime = time + check[1];
                        }
                        else{
                            work[1] = p2MaxTime;
                            p2MaxTime += check[1];
                        }
                    }
                    queue.add(work);
                }
            }
            int num = 1;
            while (!queue.isEmpty()) {
                int[] work = queue.poll();
                if (work[0] == 0) {
                    p1.add(num++);
                } else {
                    p2.add(num++);
                }
            }
            StringBuilder sr = new StringBuilder();
            sr.append(p1.size()).append("\n");
            for (int work : p1) {
                sr.append(work).append(" ");
            }
            sr.append("\n").append(p2.size()).append("\n");
            for (int work : p2) {
                sr.append(work).append(" ");
            }
            System.out.println(sr);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
