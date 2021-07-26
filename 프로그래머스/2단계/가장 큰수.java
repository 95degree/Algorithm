import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] array = new String[numbers.length];
        for(int i =0; i<numbers.length; i++){
            array[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(array, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return (s2+s1).compareTo(s1+s2);
            }
        });
        StringBuilder sr = new StringBuilder();
        for(String str : array){
            sr.append(str);
        }
        if(sr.charAt(0) == '0'){
            return "0";
        }
        answer = sr.toString();
        return answer;
    }
}
