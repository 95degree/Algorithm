mport java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            br.readLine();
            char[] array = br.readLine().toCharArray();
            long pow = 1;
            long answer = 0;
            for(char character : array){
                long index = character-'a'+1;
                answer+=(index*pow)%1234567891;
                pow=(pow*31)%1234567891;
            }
            System.out.println(answer%1234567891);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
