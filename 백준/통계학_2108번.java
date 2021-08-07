import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        long[] answer = new long[4];
        Map<Integer,Integer>map = new HashMap<>();
        for(int i =0; i<n; i++){
            int num = sc.nextInt();
            array[i] = num;
            map.put(num,map.getOrDefault(num,0)+1);
        }
        double check = 0;
        for(int num : array){
            check+=num;
        }

        List<Integer>list = new ArrayList<>(map.values());
        List<Integer>integers = new ArrayList<>();
        Collections.sort(list);
        int max = list.get(list.size()-1);
        for(Integer num : map.keySet()){
            if(map.get(num)==max){
                integers.add(num);
            }
        }
        Arrays.sort(array);
        Collections.sort(integers);
        max = integers.get(0);
        if(integers.size()>1){
            max = integers.get(1);
        }
        answer[0] = Math.round(check/(n));
        answer[1] = array[(n-1)/2];
        answer[2] = max;
        answer[3] = array[n-1] - array[0];
        for(long num : answer){
            System.out.println(num);
        }
    }
}
