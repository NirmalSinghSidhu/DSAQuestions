package nirmal.strings;

public class RobinKarpAlgorithm {

    /*
    Input:  txt[] = “THIS IS A TEST TEXT”, pat[] = “TEST”
    Output: Pattern found at index 10

    Input:  txt[] =  “AABAACAADAABAABA”, pat[] =  “AABA”
    Output: Pattern found at index 0
              Pattern found at index 9
              Pattern found at index 12
     */

    //The Rabin Karp algorithm uses a rolling hash function
    // to efficiently search for a pattern in a text
    private static final int PRIME = 101;
    public static void search(String pattern , String text){
        int patternLength = pattern.length();
        int textLength = text.length();
        int patternHash = calculateHash(pattern,patternLength);
        int textHash = calculateHash(text,patternLength);

        for(int i = 0; i<= textLength -patternLength; i++){
            if(patternHash == textHash && checkEqual(pattern,text,i,i+patternLength-1)){
                System.out.println("Pattern found at Index "+i);
            }

            if(i<textLength-patternLength){
                textHash = recalculateHash(text,i,i+patternLength,textHash,patternLength);
            }
        }
    }
    private static int calculateHash(String str, int length) {
        int hash  = 0;
        for(int i  = 0; i < length; i++){
            hash += str.charAt(i)*Math.pow(PRIME,i);
        }
        return hash;
    }

    private static int recalculateHash(String str, int oldIndex, int newIndex, int oldHash, int patternLength) {
      int newHash = oldHash - str.charAt(oldIndex);
      newHash /= PRIME;
      newHash += str.charAt(newIndex)*Math.pow(PRIME,patternLength-1);
      return newHash;
    }

    private static boolean checkEqual(String pattern, String text, int start, int end) {
        int patternIndex = 0;
        for (int i = start; i <= end; i++) {
            if (pattern.charAt(patternIndex) != text.charAt(i)) {
                return false;
            }
            patternIndex++;
        }
        return true;

    }


    public static void main(String[] args) {
        String text = "ABABCABABABA";
        String pattern = "ABA";
        search(pattern, text);
    }
}
