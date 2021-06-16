class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        for(int i = 0; i<strings.length; i++){
            for(int j = 0; j<strings.length-1; j++){
                if(strings[j].charAt(n)>strings[j+1].charAt(n)){
                    String tmp = strings[j];
                    strings[j] = strings[j+1];
                    strings[j+1] = tmp;
                }
                else if(strings[j].charAt(n)==strings[j+1].charAt(n)){
                    if (strings[j].compareTo(strings[j+1])>0){
                        String tmp = strings[j];
                        strings[j] = strings[j+1];
                        strings[j+1] = tmp;
                    }
                }
            }
        } 
        answer = strings;
        return answer;
    }
}
