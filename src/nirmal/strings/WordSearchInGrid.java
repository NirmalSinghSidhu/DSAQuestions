package nirmal.strings;

public class WordSearchInGrid {
    public static boolean searchWord(char[][] grid, String word) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == word.charAt(0) && dfs(grid, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(char[][] grid, String word, int row, int col, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] || grid[row][col] != word.charAt(index)) {
            return false;
        }

        visited[row][col] = true; // Mark the current element as visited

        if (dfs(grid, word, row + 1, col, index + 1, visited) ||
                dfs(grid, word, row - 1, col, index + 1, visited) ||
                dfs(grid, word, row, col + 1, index + 1, visited) ||
                dfs(grid, word, row, col - 1, index + 1, visited)) {
            return true;
        }

        visited[row][col] = false; // Restore the visited status

        return false;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        boolean found = searchWord(grid, word);
        System.out.println("Word '" + word + "' found in the grid: " + found);
    }
}
