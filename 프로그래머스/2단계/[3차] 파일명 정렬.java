import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        Arrays.sort(files,new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                String s1Head = findHead(s1);
                String s2Head = findHead(s2);
                if(s1Head.equalsIgnoreCase(s2Head)){
                    return findNum(s1,s1Head.length()) - findNum(s2,s2Head.length());
                }
                return s1Head.toUpperCase().compareTo(s2Head.toUpperCase());
            }
        });
        answer = files;
        return answer;
    }
    
    public String findHead(String file){
        for(int i = 0; i<file.length(); i++){
            char ch = file.charAt(i);
            if(Character.isDigit(ch)){
                return file.substring(0,i);
            }
        }
        return " ";
    }
    
    public int findNum(String file,int index){
        StringBuilder sr = new StringBuilder();
        for(int i =index; i<file.length(); i++){
            char ch = file.charAt(i);
            if(Character.isDigit(ch) && sr.length()<5){
                sr.append(ch);
            }
            else{
                return Integer.parseInt(sr.toString());
            }
        }
        return Integer.parseInt(sr.toString());
    }
}
