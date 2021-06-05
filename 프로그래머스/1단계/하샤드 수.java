import java.util. *;
class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String[] stringNumberArray = Integer.toString(x).split("");
        int i =0;
        for(String num : stringNumberArray){
            i+=Integer.parseInt(num);
        }
        answer = (x%i)==0;
        return answer;
    }
}
