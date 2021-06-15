class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        int length = s.length();
        if(length!=4 && length!=6){
            return answer;
        }
        char[] charArray = s.toCharArray();
        int count=0;
        for(char ch : charArray){
            if(ch<'0' || ch>'9')
                return answer;
        }
        answer = true;
        return answer;
    }
}
