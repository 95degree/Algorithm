import java.util. *;
class Solution {
    public long solution(long n) {
        long answer = 0;
        char[] numCharArray = Long.toString(n).toCharArray();
        List<Integer> list = new ArrayList<>();
        for(char num : numCharArray){
            list.add(num -'0');
        }
        Collections.sort(list,Collections.reverseOrder());
        StringBuilder sr = new StringBuilder();
        for(Integer num : list){
            sr.append(num.toString());
        }
        answer = Long.parseLong(sr.toString());
        return answer;
    }
}
