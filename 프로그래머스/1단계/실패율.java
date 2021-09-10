//정렬 구현 좀더 빠르다//
import java.util.*;
class Solution {
    public class Fail{
        int step;
        double failure;
        
        public Fail(int step, double failure){
            this.step = step;
            this.failure = failure;
        }
    }
    
    public int[] solution(int N, int[] stages) {
         Fail[] failes = new Fail[N];
         int[] answer = new int[N+1];
         double[] people = new double[N+1];
         int[] rank = new int[N];
         for(int num : stages){
             answer[num-1]++;
             for(int i =0; i<num; i++){
                 people[i]++;
             }
         }
        
         for(int i =0; i<failes.length; i++){
             double fail = 0;
             if(people[i] !=0){
                 fail = answer[i]/people[i];
             }
             failes[i] = new Fail(i+1, fail);
         }
         
        Arrays.sort(failes,(o1,o2) ->{
           int compare = Double.compare(o2.failure,o1.failure);
           if(compare == 0){
               return o1.step-o2.step;
           }
           return compare;
        });
        
         for(int i =0; i<failes.length; i++){
             rank[i] = failes[i].step;
         }
        
         return rank;
    }
}

//save List 만들어서 비교//
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
