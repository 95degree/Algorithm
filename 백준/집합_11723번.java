//원소 추가 num |= (1<<i)
//원소 확인 (num & (1<<i)) > 0
//원소 삭제 num &= ~ (1<<i)
//원소 토글(있으면 삭제 없으면 추가) num ^= (1<<i)
//원소 숫자들(1~i) 추가 (1<<i+1) -1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int set = 0;
            StringBuilder sr = new StringBuilder();
            for (int i = 0; i < n; i++) {
                String[] work = br.readLine().split(" ");
                String doing = work[0];
                if (doing.equals("add")) {
                    set |= (1 << Integer.parseInt(work[1]));
                } else if (doing.equals("check")) {
                    int num = Integer.parseInt(work[1]);
                    if ((set & (1 << num)) > 0) {
                        sr.append(1).append("\n");
                    } else {
                        sr.append(0).append("\n");
                    }
                } else if (doing.equals("remove")) {
                    set &= ~(1 << Integer.parseInt(work[1]));
                } else if (doing.equals("toggle")) {
                    set ^= (1 << Integer.parseInt(work[1]));
                } else if (doing.equals("all")) {
                    set = (1 << 21) - 1;
                } else {
                    set = 0;
                }
            }
            System.out.println(sr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
