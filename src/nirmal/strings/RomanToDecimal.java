package nirmal.strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToDecimal {

    public static int convertToDecimal(String romanNumeral){
        Map<Character,Integer> romanMap = createRomanMapping();
        int decimal = 0;
        int length = romanNumeral.length();

        for(int i = 0; i<length; i++){
            int currentSymbolValue = romanMap.get(romanNumeral.charAt(i));
            if(i<length-1){
                int nextSymbolValue = romanMap.get(romanNumeral.charAt(i+1));
                if(currentSymbolValue < nextSymbolValue){
                    decimal -= currentSymbolValue;
                }else{
                    decimal += currentSymbolValue;
                }
            }
            else{
                decimal+= currentSymbolValue;
            }
        }
        return decimal;
    }
    private static Map<Character, Integer> createRomanMapping() {

        Map<Character, Integer> mapping = new HashMap<>();
        mapping.put('I', 1);
        mapping.put('V', 5);
        mapping.put('X', 10);
        mapping.put('L', 50);
        mapping.put('C', 100);
        mapping.put('D', 500);
        mapping.put('M', 1000);
        return mapping;
    }

    public static void main(String[] args) {
        String romanNumeral = "XIV";
        int decimal = convertToDecimal(romanNumeral);
        System.out.println("Decimal representation: " + decimal);
    }
}
