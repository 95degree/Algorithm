import java.util.*;
class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] charArray = s.toCharArray();
        for(int i =0; i<charArray.length; i++){
            if(charArray[i] == ' '){
                continue;
            }
            else if(charArray[i]+n > 'z' && charArray[i]<='z'){
                charArray[i]+=n+'a'-1;
                charArray[i]-='z';
            }
            else if(charArray[i]+n >'Z' && charArray[i]<='Z'){
                charArray[i]+=n+'A'-1;
                charArray[i]-='Z';
            }
            else{
                charArray[i] += n;
            }
        }
        answer = String.valueOf(charArray);
        return answer;
    }
}

// %26으로 26 자리를 넘어가면 다시 처음 인덱스 부터 시작 할수 있다.
import java.util.*;
class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] charArray = s.toCharArray();
        for(int i =0; i<charArray.length; i++){
            if(charArray[i] == ' '){
                continue;
            }
            else if(Character.isLowerCase(charArray[i])){
                charArray[i]=(char)((charArray[i] - 'a' + n)%26 + 'a'); // -> - 'a' 없이 진행하려고했지만 int로 변환이 되어 더구나 'a' 안해주면 올바르지 않다
                                                                        // 아스키 코드에는 알파벳만 있는것이 아니니까 
            }
            else
                charArray[i] =(char)((charArray[i] - 'A'+ n)%26 + 'A');
        }
        answer = String.valueOf(charArray);
        return answer;
    }
}
