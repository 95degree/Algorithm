import java.util.*;
public class Solution {
     public String[] sharp = {"C#", "D#" ,"F#", "G#", "A#"};
     public String[] lower = {"c", "d", "f", "g", "a"};   
     private class Music{

        public int length;
        public String name;
        public String melody;

        public Music(String start, String last, String name, String melody){
            this.length = parser(start,last);
            this.name = name;
            this.melody = fullMelody(melody);
        }

        public String fullMelody(String melody){
            StringBuilder sr = new StringBuilder();
            for(int i =0; i<length; i++){
                sr.append(melody.charAt(i%melody.length()));
            }
            return sr.toString();
        }

        public int parser(String start, String last){
            int startTime = createTime(start);
            int lastTime = createTime(last);
            return lastTime - startTime;
        }
         
        private int createTime(String time){
            String[] timeSplit = time.split(":");
            return Integer.parseInt(timeSplit[0])*60+Integer.parseInt(timeSplit[1]);
        }
    }

    public String solution(String m, String[] musicinfos) {
        String answer = "";
        m = change(m);
        List<Music> list = new ArrayList<>();
        List<Music> correct = new ArrayList<>();
        for (String music : musicinfos) {
            String[] musicCheck = music.split(",");
            list.add(new Music(musicCheck[0], musicCheck[1], musicCheck[2], change(musicCheck[3])));
        }
        for(Music music : list){
            if(music.melody.contains(m)){
                correct.add(music);
            }
        }
        if(correct.size() == 0){
            return "(None)";
        }
        Music checkMusic = correct.get(0);
        for(Music music : correct){
            if(checkMusic.length<music.length){
                checkMusic = music;
            }
        }
        return checkMusic.name;
    }
    
    public String change(String melody){
        for(int i = 0; i<sharp.length; i++){
            melody = melody.replaceAll(sharp[i],lower[i]);
        }
        return melody;
    }
}
