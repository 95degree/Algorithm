import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] check = new int[3];
        List<Integer>list = new ArrayList<>();
        int[] people1 = {1,2,3,4,5};
        int[] people2 = {2,1,2,3,2,4,2,5};
        int[] people3 = {3,3,1,1,2,2,4,4,5,5};
        for(int i=0; i<answers.length; i++){
            if(people1[i%people1.length] == answers[i]){
                check[0]++;
            }
            if(people2[i%people2.length] == answers[i]){
                check[1]++;
            }
            if(people3[i%people3.length] == answers[i]){
                check[2]++;
            }
        }
        int max = Math.max(Math.max(check[0],check[1]),check[2]);
        
        for(int i=0; i<check.length; i++){
            if(max==check[i]){
                list.add(i+1);
            }
        }
        answers = new int[list.size()];
        
        for(int i=0; i<answers.length; i++){
            answers[i] = list.get(i);
        }
        return answers;
    }
}
