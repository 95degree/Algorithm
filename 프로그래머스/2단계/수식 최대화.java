import java.util.*;
class Solution {
    char[] ch = {'*','-','+'};
    boolean[] use = new boolean[3];
    long answer = 0;
    List<Long>numList1 = new ArrayList<>();
    List<String> list1 = new ArrayList<>();
    
    public long solution(String expression) {
        int[] array = new int[3];
        String[] str = expression.replaceAll("[+,*,-]", " ").split(" ");
        for(String a : str){
            numList1.add(Long.parseLong(a));
        }
        String[] cal = expression.replaceAll("[0-9]", "").split("");
        for(String a : cal){
            list1.add(a);
        }
        dfs(array,1);
        return answer;
    }
    
    public void dfs(int[] array, int count){
        if(count>3){
            answer = Math.max(answer,calculate(array));
            return;
        }
        
        for(int i =0; i<3; i++){
            if(use[i]) continue;
            array[count-1] = i;
            use[i] = true;
            dfs(array,count+1);
            use[i] = false;
        }
    }
    
    public long calculate(int[] array){
        List<Long> numList2 = new ArrayList<>(numList1);
        List<String>list2 = new ArrayList<>(list1);
        for(int i =0; i<3; i++){
            char cha = ch[array[i]];
            for(int j =0; j<list2.size(); j++){
                if(!list2.get(j).equals(String.valueOf(cha))) continue; 
                long check = 0;
                if(cha == '+') check = numList2.get(j) + numList2.get(j+1);
                else if(cha == '*') check = numList2.get(j) * numList2.get(j+1);
                else check = numList2.get(j)-numList2.get(j+1);
                numList2.remove(j+1);
                numList2.remove(j);
                list2.remove(j);
                numList2.add(j, check);
                j--;
            }
        }
        return Math.abs(numList2.get(0));
    }
}
