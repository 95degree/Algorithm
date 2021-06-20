import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        int length = arr1.length;
        List<String> list = new ArrayList<>();
        StringBuilder sr = new StringBuilder();
        for(int i=0; i<length; i++){
            sr.setLength(0);
            for(int j=0; j<n; j++){
                String a = addDigit(n,Integer.toBinaryString(arr1[i]));
                String b = addDigit(n,Integer.toBinaryString(arr2[i]));
                if(a.charAt(j) == '1' || b.charAt(j) == '1'){
                    sr.append("#");
                }
                else{
                    sr.append(" ");
                }
            }
            list.add(sr.toString());
        }
        answer = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    private String addDigit(int n,String a){
        StringBuilder sr = new StringBuilder();
        int length = a.length();
        for(int i=0; i<n-length; i++){
            sr.append("0");
        }
        return sr.toString()+a;
    }
}
