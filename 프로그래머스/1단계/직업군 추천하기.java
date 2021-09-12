//map + 정렬 구현으로 풀기//
import java.util.*;
class Solution {
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        Map<String,Integer> prefer = new HashMap<>();
        for(int i =0; i<languages.length; i++){
            prefer.put(languages[i],preference[i]);
        }
        String[] name = new String[5];
        int[][] rank = new int[5][2];
        for(int i =0; i<table.length; i++){
            String[] score = table[i].split(" ");
            rank[i][0] = i;
            name[i] = score[0];
            for(int j =1; j<score.length; j++){
                if(prefer.containsKey(score[j])){
                    rank[i][1] += prefer.get(score[j])*(6-j);
                }
            }
        }
        Arrays.sort(rank,(o1,o2) -> {
            if(o1[1] == o2[1]){
                return name[o1[0]].compareTo(name[o2[0]]);
            }
            return o2[1] - o1[1];
        });
        answer = name[rank[0][0]];
        return answer;
    }
}
//좀 더 효율적으로 풀기 asList로 만들어주고 indexOf로 점수를 체크한다. 주의할점 원하는 값이 있는 index가 없으면 -1을 반환한다.//
//그리고 정렬을 그냥 값을 비교하면서 해준다.//
import java.util.*;
class Solution {
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        int score = -1;
        for(String job : table){
            List<String> list = Arrays.asList(job.split(" "));
            int checkScore = 0;
            String name = list.get(0);
            for(int j =0; j<languages.length; j++){
                int index = list.indexOf(languages[j]);
                if(index!=-1){
                    checkScore += (6-index) * preference[j];
                }
            }
            if(score<checkScore){
                score = checkScore;
                answer = name;
            }
            else if(score == checkScore && answer.compareTo(name)>0){
                answer = name;
            }
        }
        return answer;
    }
}
