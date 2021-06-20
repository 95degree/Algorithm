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

// 비트 연산자로 푸는 방법
import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int length = arr1.length;
        StringBuilder sr = new StringBuilder();
        for(int i=0; i<n; i++){
            sr.setLength(0);
            String a = Integer.toBinaryString(arr1[i]|arr2[i]);
            for(int j=0; j<n-a.length(); j++){
                sr.append("0");
            }
            a = sr.toString()+a;
            sr.setLength(0);
            for(int k=0; k<a.length(); k++){
                    if(a.charAt(k) == '0'){
                        sr.append(" ");
                    }
                    else{
                        sr.append("#");
                    }  
                }
            answer[i] = sr.toString();
        }
        return answer;
    }
}
