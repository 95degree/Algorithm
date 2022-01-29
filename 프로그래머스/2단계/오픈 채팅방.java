import java.util.*;

class Solution {
    
    class State {
        
        public String id;
        public char state;
        
        public State(String id, char state){
            this.id = id;
            this.state = state;
        }
    }
    
    public String[] solution(String[] record) {
        Map<String,String> map = new HashMap<>();
        List<State>list = new ArrayList<>();
        
        for(String str : record){
            String[] array = str.split(" ");
            char ch = array[0].charAt(0);
            String id = array[1];
            
            if(ch == 'E' || ch =='C'){
                map.put(id,array[2]);
            }
            
            if(ch == 'E' || ch == 'L'){
                list.add(new State(id,ch));
            }
        }
        
        List<String> str = new ArrayList<>();
        
        for(State state : list){
            StringBuilder sr = new StringBuilder();
            char ch = state.state;
            sr.append(map.get(state.id)).append("님이 ");
            if(ch == 'E'){
                sr.append("들어왔습니다.");
            } else {
                sr.append("나갔습니다.");
            }
            str.add(sr.toString());
        }
        String[] answer = new String[str.size()];
        str.toArray(answer);
        return answer;
    }
}
