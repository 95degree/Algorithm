import java.util.*;
class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int length = phone_number.length();
        String star = "*";
        StringBuilder stringBuilder = new StringBuilder();
        for(int i =0; i<length-4; i++){
            stringBuilder.append(star);
        }
        
        stringBuilder.append(phone_number.substring(length-4,length));
        answer = stringBuilder.toString();
        return answer;
    }
}

//문제를 풀때 항상 있는 값을 활용하는 방법을 생각해본다. !!!
//문자열을 먼저 자르고 붙이는게 아니라 -> char배열로 만들고 length-4 index 전까지 *을 넣고 다시 String으로 만든다.
import java.util.*;
class Solution {
    public String solution(String phone_number) {
        String answer = "";
        char[] charArray = phone_number.toCharArray();
        for(int i =0; i<phone_number.length()-4; i++){
            charArray[i] = '*';
        }
        answer = String.valueOf(charArray);
        return answer;
    }
}

