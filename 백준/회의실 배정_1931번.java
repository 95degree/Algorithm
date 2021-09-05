//이너클래스로 풀기//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class meeting {
        int start;
        int end;

        public meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            meeting[] meetings = new meeting[n];
            int answer = 1;
            for (int i = 0; i < n; i++) {
                StringTokenizer str = new StringTokenizer(br.readLine());
                meetings[i] = new meeting(Integer.parseInt(str.nextToken()), Integer.parseInt(str.nextToken()));
            }
            Arrays.sort(meetings, (o1, o2) -> {
                if (o1.end == o2.end) {
                    return o1.start - o2.start;
                }
                return o1.end - o2.end;
            });

            int i = 1;
            int lastEnd = meetings[0].end;
            while (i < n) {
                int start = meetings[i].start;
                if (start >= lastEnd) {
                    answer++;
                    lastEnd = meetings[i].end;
                }
                i++;
            }
            System.out.println(answer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//2차원배열로 풀기//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int[][] meetings = new int[n][2];
            int answer = 0;
            for (int i = 0; i < n; i++) {
                StringTokenizer str = new StringTokenizer(br.readLine());
                for(int j =0; j<2; j++){
                    meetings[i][j] = Integer.parseInt(str.nextToken());
                }
            }
            Arrays.sort(meetings, (o1, o2) -> {
                if(o1[1]==o2[1]) {
                    return o1[0]-o2[0];
                }
                return o1[1]-o2[1];
            });
            int i =0;
            int lastEnd = 0;
            while(i<n){
                int start = meetings[i][0];
                if(start>=lastEnd){
                    answer++;
                    lastEnd = meetings[i][1];
                }
                i++;
            }
            System.out.println(answer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
