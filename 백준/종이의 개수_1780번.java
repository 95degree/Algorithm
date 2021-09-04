 //항상 구현을 하기전 아래처럼 생각을 해보고 풀어보자//

//처음에 기준을 세운다. (0,0)
    //기준을 바탕으로 9등분 하는걸 만든다.
    //i<3, j<3 이중포문으로 9번 돌게 한다.//
    //스타트 지점을 직접 구해 본다.//
    //00, 03, 06, 30, 33, 36,  60, 63, 66 ->length 가 9일 경우//
    //00, 09, 018, 90, 99, 918, 180, 189, 1818 -> length가 27일 경우//
    //startX+i*length startY+j*length -> 스타트 지점을 구할 수 있다.//




//내가 푼거//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int one;
    static int minus;
    static int zero;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder sr = new StringBuilder();
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer str = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(str.nextToken());
                }
            }
            cut(map);
            sr.append(minus).append("\n").append(zero).append("\n").append(one);
            System.out.println(sr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void cut(int[][] map) {
        int num = map[0][0];
        int answer = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] != num) {
                    if (map.length == 3) {
                        oneCheck(map);
                        return;
                    }
                    int index = map.length / 3;
                    for (int k = 0; k < 3; k++) {
                        int startX = k * index;
                        for (int p = 0; p < 3; p++) {
                            int startY = p * index;
                            cut(makePaper(map, startX, startY, index));
                        }
                    }
                    return;
                } else {
                    answer++;
                }
            }
        }
        if (answer == map.length * map.length) {
            check(num);
        }
    }

    private static int[][] makePaper(int[][] map, int startX, int startY, int index) {
        int[][] newMap = new int[index][index];
        for (int i = 0; i < index; i++) {
            int start = startX + i;
            for (int j = 0; j < index; j++) {
                newMap[i][j] = map[start][startY + j];
            }
        }
        return newMap;
    }

    private static void oneCheck(int[][] map) {
        int num = map[0][0];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                check(map[i][j]);
            }
        }
    }

    private static void check(int num) {
        if (num == 0) {
            zero++;
        } else if (num == 1) {
            one++;
        } else {
            minus++;
        }
    }
}

//더 간단히 구현하기 + 구현을 어떻게 해보는지//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] check = new int[3];
    static int[][] map;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder sr = new StringBuilder();
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer str = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(str.nextToken());
                }
            }
            cut(0,0,n);
            for(int num : check){
                sr.append(num).append("\n");
            }
            System.out.println(sr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void cut(int startX, int startY, int length) {
       if(checkArray(startX,startY,length)){
          //-1 0 1 -> 0 1 2 index로 체크 가능//
           check[map[startX][startY]+1]++;
           return;
       }
       int newLength = length/3;
       for(int i =0; i<3; i++){
           for(int j=0; j<3; j++){
               cut(startX+i*newLength,startY+j*newLength,newLength);
           }
       }
    }

    //길이가 1일 경우 항상 true를 리턴한다.!!//
    private static boolean checkArray(int startX, int startY, int length){
        int num = map[startX][startY];
        for(int i = startX; i<startX+length; i++){
            for(int j = startY; j<startY+length; j++){
                if(map[i][j] != num){
                    return false;
                }
            }
        }
        return true;
    }
}
