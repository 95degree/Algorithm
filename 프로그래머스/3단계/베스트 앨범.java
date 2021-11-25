import java.util.*;

class Solution {
    class Music {
        public String genre;
        public int count;
        public int index;
        
        public Music(String genre, int count, int index){
            this.genre = genre;
            this.count = count;
            this.index = index;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String,Integer> map = new HashMap<>();
        Music[] musics = new Music[genres.length];
        for(int i =0; i<genres.length; i++){
            map.put(genres[i],map.getOrDefault(genres[i],0)+plays[i]);
            musics[i] = new Music(genres[i],plays[i],i);
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list,(o1,o2) -> {
            return map.get(o2) - map.get(o1);
        });
        for(int i =0; i<list.size(); i++){
            map.put(list.get(i),i);
        }
        Arrays.sort(musics,(o1,o2) -> {
            if(map.get(o2.genre) == map.get(o1.genre)){
                if(o1.count == o2. count){
                    return o1.index - o2.index;
                }
                return o2.count - o1.count;
            }
            return map.get(o1.genre) - map.get(o2.genre);
        });
        
        List<Integer> answerList = new ArrayList<>();
        int num = 2;
        String pre = musics[0].genre;
        for(int i = 0; i<musics.length; i++){
            String now = musics[i].genre;
            if(!pre.equals(now)){
                num = 2;
            }
            if(num==0){
                continue;
            } else{
                answerList.add(musics[i].index);
                num--;
                pre = now;
            }
        }
        int[] answer = new int[answerList.size()];
        for(int i =0; i<answer.length; i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
