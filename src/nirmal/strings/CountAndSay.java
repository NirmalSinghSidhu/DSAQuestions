package nirmal.strings;

public class CountAndSay {
    public static  String countAndSay(int n){
        if(n <= 0){
            return "";
        }
        if(n == 1){
            return "1";
        }

        String previous = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i = 1; i < previous.length();i++){
            if(previous.charAt(i)==previous.charAt(i-1)){
                count++;
            }else {
                sb.append(count).append(previous.charAt(i-1));
                count = 1;
            }
        }
        sb.append(count).append(previous.charAt(previous.length()-1));
        return sb.toString();
    }

    //iterative approach

    public static  String countAndSay2(int n){
        if(n<=0){
            return "";
        }
        String sequence = "1";

        for(int i = 1;i<n;i++){
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for(int j = 1; j<sequence.length();j++){
                if(sequence.charAt(j-1) == sequence.charAt(j)){
                    count++;
                }else{
                    sb.append(count).append(sequence.charAt(j-1));
                    count = 1;
                }
            }

            sb.append(count).append(sequence.charAt(sequence.length()-1));
            sequence = sb.toString();
        }
        return sequence;
    }
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(3));
    }
}
