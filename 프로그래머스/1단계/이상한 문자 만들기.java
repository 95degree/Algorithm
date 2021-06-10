import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        char[] array = s.toUpperCase().toCharArray();
        int j =0;
        for(int i =0; i<array.length; i++){
            if(array[i] == ' '){
                j = 1;
            }
            if(j%2 != 0){
                array[i] = Character.toLowerCase(array[i]);
            }
            j++;
        }
        answer = String.valueOf(array);
        return answer;
    }
}
