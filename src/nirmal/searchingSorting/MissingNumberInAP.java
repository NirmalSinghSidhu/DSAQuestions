package nirmal.searchingSorting;

public class MissingNumberInAP {
    //Linear Search Approach

    public static int findMissingNumber(int[] arr){
        int n = arr.length;
        int commonDifference = (arr[n-1]-arr[0])/n;

        for(int i = 1; i < n; i++){
            if(arr[i]-arr[i-1] != commonDifference){
                return commonDifference + arr[i -1];
            }
        }

        //if no missing number found in the Ap series then return the last element
        return arr[n-1];
    }

    //Binary Search Approach
    public static int findMissingNumber2(int[] arr){
        int n = arr.length;
        int commonDifference = (arr[n-1]-arr[0])/n;

        int start = 0;
        int end = n-1;

        while(start < end){
            int mid = start + (end-start)/2;
            if(arr[mid] == arr[0] + commonDifference*mid){
                start = mid+1;
            }else{
                end = mid;
            }
        }

        return arr[start] - commonDifference;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 10, 12};
        int missingNumber = findMissingNumber2(arr);
        System.out.println("Missing Number: " + missingNumber);
    }
}
