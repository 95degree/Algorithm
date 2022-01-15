import java.util.*;
class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers,target,0);
        return answer;
    }
    
    public void dfs(int[]numbers, int target, int index){
        if(index == numbers.length){
            if(possible(numbers,target)){
                answer++;
            }
            return;
        }
        for(int i =0; i<2; i++){
           numbers[index]*=-1;
           dfs(numbers,target,index+1); 
        }
    }
    
    public boolean possible(int[] numbers, int target){
        int count = 0;
        for(int num : numbers){
            count += num;
        }
        return count == target;
    }
}


import java.util.*;
class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(0,numbers,target,0);
        return answer;
    }
    
    private void dfs(int depth, int[]numbers, int target, int sum){
        if(depth==numbers.length){
            if(target == sum){
                 answer++;
            }
            return;
        }
        dfs(depth+1,numbers,target,sum + numbers[depth]);
        dfs(depth+1,numbers,target,sum - numbers[depth]);
    }
}
