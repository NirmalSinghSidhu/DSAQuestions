package nirmal.searchingSorting;

public class SquareRoot {
    public static int sqrt(int x){
        if(x==0||x==1){
            return x;
        }

        int i =1;
        while(i*i<=x){
            i++;
        }
        return i -1;
    }

    //binarySearch

    public static int sqrt2(int x){
        if(x == 0 || x==1){
            return x;
        }

        int start = 1;
        int end = x; //4

        int result = 0;
        while(start <= end){
            int mid = start+(end-start)/2;   //2
            if(mid <= x/mid) {
                start = mid +1;
                result = mid;
            }else {
                end = mid -1;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int x = 35;
        int result = sqrt(x);
        System.out.println("Square root: " + result);
    }
}
