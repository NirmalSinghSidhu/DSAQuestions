package nirmal.strings;

import java.util.HashMap;
import java.util.Map;

public class DuplicateCharacterInString {
    public static void findDuplicates(String str){
        Map<Character,Integer> freq = new HashMap<>();

        for(char c : str.toCharArray()){
            freq.put(c,freq.getOrDefault(c,0)+1);
        }

        for(Map.Entry<Character,Integer> entry : freq.entrySet()){
            if(entry.getValue() > 1){
                System.out.println(entry.getKey());
            }
        }

    }

    public static void main(String[] args) {
        findDuplicates("aabcddefghii");    }
}
