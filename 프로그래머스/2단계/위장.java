import java.util. *;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String,Integer> clotheMap = new HashMap<>();
        for(String[] clothArray : clothes){
            clotheMap.put(clothArray[1],clotheMap.getOrDefault(clothArray[1],0)+1);
        }
        for(String key : clotheMap.keySet()){
            answer*=clotheMap.get(key)+1;
        }
        return answer-1;
    }
}
