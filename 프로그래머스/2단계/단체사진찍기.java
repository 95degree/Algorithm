import java.util.*;

class Solution {
    int answer = 0;
    String[]data;
    char[] people = {'A','C','F','J','M','N','R','T'};
    boolean[] check = new boolean[8];
    
    public int solution(int n, String[] data) {
        this.data = data;
        Map<Character,Integer>map = new HashMap<>();
        dfs(map,1);
        return answer;
    }
    
    public void dfs(Map<Character,Integer>map,int count){
        if(count>8){
            if(check(map)){
                answer++;
            }
            return;
        }
        
        for(int i =0; i<8; i++){
            if(check[i]) continue;
            map.put(people[i],count);
            check[i] = true;
            dfs(map,count+1); 
            check[i] = false;
        }
    }
    
    public boolean check(Map<Character,Integer> map){
        for(String a : data){
            int distance = Math.abs(map.get(a.charAt(0)) - map.get(a.charAt(2))) -1;
            char ch = a.charAt(3);
            int num = a.charAt(4) - '0';
            if(ch == '=' && distance != num) return false;
            if(ch == '<' && distance >= num) return false;
            if(ch == '>' && distance <= num) return false;
        }
        return true;
    }
}
