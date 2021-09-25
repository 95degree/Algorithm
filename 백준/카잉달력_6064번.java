//나머지 정리를 이용한 브루트 포스 문제  y == n 이 같을 경우 나머지가 n이 아니라 0이다. //
//max 값은 최소공배수(최소 공배수를 구하든 안하든 시간은 비슷해서 그냥 두 개의 곱으로 진행했다. 보통 최소 공배수는 두개의 곱인 경우가 많으니까) 인데 그 이유는 최소 공배수가 결국 <m:n>
//이기 떄문이다. 예를 들어 2 6  이면 결국 최소공배수인 6이 <2:6>이 된다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            StringBuilder st = new StringBuilder();
            for(int i =0; i<t; i++){
                StringTokenizer sr = new StringTokenizer(br.readLine());
                int m = Integer.parseInt(sr.nextToken());
                int n = Integer.parseInt(sr.nextToken());
                int x = Integer.parseInt(sr.nextToken());
                int y = Integer.parseInt(sr.nextToken());
                if(y==n){
                    y=0;
                }
                int index = 0;
                int answer = -1;
                int max = m*n;
                while(m*index+x < max){
                    if((m*index+x)%n ==y){
                        answer = m*index+x;
                        break;
                    }
                    index++;
                }
                st.append(answer).append("\n");
            }
            System.out.println(st);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
