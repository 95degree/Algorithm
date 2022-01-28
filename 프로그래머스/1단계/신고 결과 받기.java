import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String,Set<String>> decl = new HashMap<>();
        Map<String,Set<String>> encon = new HashMap<>();
        Set<String> list = new HashSet<>();
        
        for(String str : id_list){
            decl.put(str,new HashSet<String>());
            encon.put(str,new HashSet<String>());
        }
        
        for(String str : report){
            String[] ar = str.split(" ");
            
            String p1 = ar[0];
            String p2 = ar[1];
            
            Set<String> set1 = decl.get(p1);
            Set<String> set2 = encon.get(p2);
            
            set1.add(p2);
            set2.add(p1);
        }
        
        for(String str : encon.keySet()){
            int size = encon.get(str).size();
            if(!(size>=k)) continue;
            list.add(str);
        }
        
        for(int i =0; i<id_list.length; i++){
            String str = id_list[i];
            Set<String>set = decl.get(str);
            int count = 0;
            for(String str2 : list){
                if(set.contains(str2)){
                    count++;
                }
            }
            answer[i] = count;
        }
        return answer;
    }
}
