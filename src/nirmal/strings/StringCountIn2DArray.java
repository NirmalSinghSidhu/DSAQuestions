package nirmal.strings;

public class StringCountIn2DArray {

    public static int countStringInArray(char[][] array , String str){
        int rows = array.length;
        int cols = array[0].length;
        int count = 0;

        for(int i = 0; i<rows;i++){
            for(int j =0; j<cols; j++){
                if(array[i][j] == str.charAt(0)){
                    count += dfs(array,str,i,j,0);
                }
            }
        }
        return count;
    }


    private static int dfs(char[][] array, String str, int row, int col, int index) {
        if (index == str.length()) {
            return 1;
        }

        if (row < 0 || row >= array.length || col < 0 || col >= array[0].length || array[row][col] != str.charAt(index)) {
            return 0;
        }

        int count = 0;
        char originalChar = array[row][col];
        array[row][col] = '#'; // Mark the current element as visited

        count += dfs(array, str, row + 1, col, index + 1); // Check down
        count += dfs(array, str, row - 1, col, index + 1); // Check up
        count += dfs(array, str, row, col + 1, index + 1); // Check right
        count += dfs(array, str, row, col - 1, index + 1); // Check left

        array[row][col] = originalChar; // Restore the original character

        return count;
    }

    public static void main(String[] args) {
        char[][] array = {
                {'A', 'B', 'C', 'D'},
                {'B', 'B', 'C', 'B'},
                {'C', 'C', 'C', 'A'},
                {'D', 'B', 'A', 'B'}
        };
        String str = "BBC";
        int count = countStringInArray(array, str);
        System.out.println("Count of '" + str + "' in the array: " + count);
    }
}

