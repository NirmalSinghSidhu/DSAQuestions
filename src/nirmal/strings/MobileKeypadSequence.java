package nirmal.strings;

import java.util.HashMap;
import java.util.Map;

public class MobileKeypadSequence {
    public static String convertToKeypadSequence(String sentence){
        Map<Character , String> keypadMap = createKeypadMap();
        StringBuilder result = new StringBuilder();

        for(char c : sentence.toCharArray()){
            if(Character.isLetter(c)){
                char ch = Character.toUpperCase(c);
                if(keypadMap.containsKey(ch)){
                    result.append(keypadMap.get(ch));
                }
            } else if (Character.isSpaceChar(c)) {
                result.append('0');
            }
        }
        return result.toString();
    }

    private static Map<Character, String> createKeypadMap() {
        Map<Character, String> mapping = new HashMap<>();
        mapping.put('A', "2");
        mapping.put('B', "22");
        mapping.put('C', "222");
        mapping.put('D', "3");
        mapping.put('E', "33");
        mapping.put('F', "333");
        mapping.put('G', "4");
        mapping.put('H', "44");
        mapping.put('I', "444");
        mapping.put('J', "5");
        mapping.put('K', "55");
        mapping.put('L', "555");
        mapping.put('M', "6");
        mapping.put('N', "66");
        mapping.put('O', "666");
        mapping.put('P', "7");
        mapping.put('Q', "77");
        mapping.put('R', "777");
        mapping.put('S', "7777");
        mapping.put('T', "8");
        mapping.put('U', "88");
        mapping.put('V', "888");
        mapping.put('W', "9");
        mapping.put('X', "99");
        mapping.put('Y', "999");
        mapping.put('Z', "9999");
        return mapping;
    }

    public static void main(String[] args) {
        String sentence = "Hello World";
        String keypadSequence = convertToKeypadSequence(sentence);
        System.out.println("Keypad sequence: " + keypadSequence);
    }
}
