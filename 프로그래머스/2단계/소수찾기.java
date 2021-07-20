//순열 알고리즘을 사용해야한다.//
import java.util.*;
class Solution {
    
    public Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        char[] array = numbers.toCharArray();
        for(int i =1; i<=numbers.length(); i++){
            permutaion(array,0,array.length,i);
        }
        for(int num : set){
            if(check(num)){
                answer++;
            }
        }
        return answer;
    }
    
    public void permutaion(char[] array, int depth, int n, int r){
        if(depth == r){
            StringBuilder sr = new StringBuilder();
            for(int i =0; i<r; i++){
                sr.append(array[i]);
            }
            set.add(Integer.parseInt(sr.toString()));
        }
        
        for(int i = depth; i<n; i++){
            swap(array,depth,i);
            permutaion(array,depth+1,n,r);
            swap(array,depth,i);
        }
    }
    
    public void swap(char[] array, int depth, int i){
        char temp = array[depth];
        array[depth] = array[i];
        array[i] = temp;
    }
    
    public boolean check(int num){
        if(num == 1 || num == 0){
            return false;
        }
        
        for(int i = 2; i<=(int)Math.sqrt(num); i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
}
