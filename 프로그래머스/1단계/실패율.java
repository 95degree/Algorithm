import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        int[] notClearPeople = new int[N+1];
        double[] people = new double[N+1];
        answer = new int[N];
        List<Double> list = new ArrayList<>();
        for(int num : stages){
            notClearPeople[num-1]++;
            for(int i=0; i<num; i++){
                people[i]++;
            }
        }
        for(int i =0; i<N; i++){
            double fail = notClearPeople[i]/people[i];
            if(people[i] == 0){
                fail = 0;
            }
            list.add(fail);
            people[i] = fail;
        }
        Collections.sort(list,Collections.reverseOrder());
        for(int i = 0; i<N; i++){
            for(int j =0; j<N; j++){
                if(list.get(i) == people[j]){
                    people[j]=-1;
                    answer[i] = j+1;
                    break;
                }
            }   
        }
         return answer;
    }
}
