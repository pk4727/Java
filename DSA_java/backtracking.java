import java.util.ArrayList;
import java.util.Arrays;

class backtracking {
    public static void main(String[] args) {
        int[][] board = new int[][] {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
        if (sudokuSolver(board)) {
            display(board);
        } else {
            System.out.println("Cannot solve");
        }

        // int n = 4;
        // boolean[][] board = new boolean[n][n];
        // knight(board, 0, 0, 4);
        // System.out.println(NqueenProblem(board, 0));

        // boolean[][] maze = { { true, true, true }, { true, true, true }, { true,
        // true, true } };
        // int[][] path = new int[maze.length][maze[0].length];
        // returnArray_maze_pathIndex_obstacle_allDirection("", 0, 0, maze, path, 1);
        // System.out.println(return_maze_path_allDirection("", 0, 0, maze));
        // System.out.println(returnArray_maze_path_obstacle2("", 0, 0, maze));
        // System.out.println(returnArray_maze_path_obstacle("", 3, 3));
        // System.out.println(returnArray_maze_path_Diagonal("", 3, 3));
        // System.out.println(returnArray_maze_path("", 3, 3));
        // return_maze_path("", 3, 3);
        // System.out.println(count_maze_path(3, 3));
    }

    static boolean sudokuSolver(int[][] board) {
        int row = -1;
        int col = -1;
        int size = board.length;
        boolean isempty = true;

        for (int i = 0; i < size; i++) // this is how we are replacing the r,c from arguments
        {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isempty = false;
                    break;
                }
            }
            if (!isempty) // if you found some empty element in row, then break (isempty == false)
            {
                break;
            }
        }

        if (isempty) // sudoku is solved (isempty == true)
        {
            return true;
        }
        // backtrack
        for (int number = 1; number <= 9; number++) {
            if (isSudokuSafe(board, row, col, number)) {
                board[row][col] = number;
                if (sudokuSolver(board)) // found the answer
                {
                    display(board);
                    System.out.println("\n");
                    return true;
                } else // backtrack
                {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    private static boolean isSudokuSafe(int[][] board, int row, int col, int ans) {
        for (int[] i : board) // check in current row
        {
            if (i[col] == ans) {
                return false;
            }
        }
        for (int i : board[row]) // check in current col
        {
            if (i == ans) {
                return false;
            }
        }
        // find coordinate for check in current sub-board part
        int sizeOfSubboard = (int) (Math.sqrt(board.length)); // 3
        int[] start = { row - row % sizeOfSubboard, col - col % sizeOfSubboard }; // 3,6
        for (int srow = start[0]; srow < start[0] + sizeOfSubboard; srow++) {
            for (int scol = start[1]; scol < start[1] + sizeOfSubboard; scol++) {
                if (board[srow][scol] == ans) {
                    return false;
                }
            }

        }
        return true;
    }

    private static void display(int[][] board) {
        for (int[] row : board) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    // =======================================================================================

    static void knight(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {
            displayBoard(board);
            System.out.println();
            return;
        }
        if (row == board.length - 1 && col == board.length) {
            return;
        }
        if (col == board.length) {
            knight(board, row + 1, col, knights);
            return;
        }
        if (isKnightSafe(board, row, col)) {
            board[row][col] = true;
            knight(board, row, col + 1, knights - 1);
            board[row][col] = false;
        }
        knight(board, row, col + 1, knights);
    }

    private static boolean isKnightSafe(boolean[][] board, int row, int col) {
        if (isValid(board, row - 2, col - 1)) {
            if (board[row - 2][col - 1]) {
                return false;
            }
        }
        if (isValid(board, row - 1, col - 2)) {
            if (board[row - 1][col - 2]) {
                return false;
            }
        }
        if (isValid(board, row - 2, col + 1)) {
            if (board[row - 2][col + 1]) {
                return false;
            }
        }
        if (isValid(board, row - 1, col + 2)) {
            if (board[row - 1][col + 2]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(boolean[][] board, int row, int col) { // check bord is valid for this
                                                                          // coordinate(row,col)
        if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
            return true;
        }
        return false;
    }

    // =========================================================================================

    static int NqueenProblem(boolean[][] board, int row) {
        if (row == board.length) {
            displayBoard(board); // display board
            System.out.println();
            return 1;
        }
        int count = 0;
        for (int col = 0; col < board.length; col++) { // traverse column wise
            if (isQueenSafe(board, row, col)) {
                board[row][col] = true; // occupy for path finding
                count += NqueenProblem(board, row + 1); // find path
                board[row][col] = false; // release after path find
            }
        }
        return count;
    }

    private static boolean isQueenSafe(boolean[][] board, int row, int col) {
        for (int i = 0; i < row; i++) // check in upper section
        {
            if (board[i][col]) {
                return false;
            }
        }
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) // check in right diagonal section
        {
            if (board[row - i][col + i]) {
                return false;
            }
        }
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) // check in left diagonal section
        {
            if (board[row - i][col - i]) {
                return false;
            }
        }
        return true;
    }

    private static void displayBoard(boolean[][] board) {
        for (boolean[] i : board) {
            for (boolean j : i) {
                if (j == true) {
                    // System.out.print("Q "); // for queen problem
                    System.out.print("K "); // for knight problem
                } else {
                    System.out.print("x ");
                }
            }
            System.out.println();
        }
    }

    // =======================================================================================

    static void returnArray_maze_pathIndex_obstacle_allDirection(String steps, int row, int col, boolean[][] maze,
            int[][] result, int step) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            result[row][col] = step;
            for (int[] i : result) {
                System.out.println(Arrays.toString(i));
            }
            System.out.println(steps + "\n");
            return;
        }
        if (!maze[row][col]) {
            return;
        }
        maze[row][col] = false;
        result[row][col] = step;
        if (row > 0) {
            returnArray_maze_pathIndex_obstacle_allDirection(steps + "U", row - 1, col, maze, result, step + 1);
        }
        if (row < maze.length - 1) {
            returnArray_maze_pathIndex_obstacle_allDirection(steps + "D", row + 1, col, maze, result, step + 1);
        }
        if (col < maze[0].length - 1) {
            returnArray_maze_pathIndex_obstacle_allDirection(steps + "R", row, col + 1, maze, result, step + 1);
        }
        if (col > 0) {
            returnArray_maze_pathIndex_obstacle_allDirection(steps + "L", row, col - 1, maze, result, step + 1);
        }
        maze[row][col] = true;
        result[row][col] = 0;
    }

    static ArrayList<String> return_maze_path_allDirection(String steps, int row, int col, boolean[][] maze) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            ArrayList<String> path = new ArrayList<>();
            path.add(steps);
            return path;
        }
        if (!maze[row][col]) {
            return new ArrayList<>();
        }
        maze[row][col] = false; // // I am considering this block in my path so consider as visited.
        ArrayList<String> ans = new ArrayList<>();
        if (row > 0) {
            ans.addAll(return_maze_path_allDirection(steps + "U", row - 1, col, maze));
        }
        if (row < maze.length - 1) {
            ans.addAll(return_maze_path_allDirection(steps + "D", row + 1, col, maze));
        }
        if (col < maze[0].length - 1) {
            ans.addAll(return_maze_path_allDirection(steps + "R", row, col + 1, maze));
        }
        if (col > 0) {
            ans.addAll(return_maze_path_allDirection(steps + "L", row, col - 1, maze));
        }
        maze[row][col] = true; // this line is where the function will be over so before the function gets
                               // removed, also remove the changes that were made by that function
        return ans;
    }

    static ArrayList<String> returnArray_maze_path_obstacle2(String steps, int row, int col, boolean[][] maze) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            ArrayList<String> path = new ArrayList<>();
            path.add(steps);
            return path;
        }
        if (!maze[row][col]) {
            return new ArrayList<>();
        }
        ArrayList<String> ans = new ArrayList<>();
        if (row < maze.length - 1) {
            ans.addAll(returnArray_maze_path_obstacle2(steps + "D", row + 1, col, maze));
        }
        if (col < maze[0].length - 1) {
            ans.addAll(returnArray_maze_path_obstacle2(steps + "R", row, col + 1, maze));
        }
        return ans;
    }

    static ArrayList<String> returnArray_maze_path_obstacle(String steps, int row, int col) {
        if (row == 1 && col == 1) {
            ArrayList<String> path = new ArrayList<>();
            path.add(steps);
            return path;
        }
        if (row == 2 && col == 2) {
            return new ArrayList<>();
        }
        ArrayList<String> ans = new ArrayList<>();
        if (row > 1) {
            ans.addAll(returnArray_maze_path_obstacle(steps + "D", row - 1, col));
        }
        if (col > 1) {
            ans.addAll(returnArray_maze_path_obstacle(steps + "R", row, col - 1));
        }
        return ans;
    }

    static ArrayList<String> returnArray_maze_path_Diagonal(String steps, int row, int col) {
        if (row == 1 && col == 1) {
            ArrayList<String> path = new ArrayList<>();
            path.add(steps);
            return path;
        }
        ArrayList<String> ans = new ArrayList<>();
        if (row > 1) {
            ans.addAll(returnArray_maze_path_Diagonal(steps + "V", row - 1, col));
        }
        if (col > 1) {
            ans.addAll(returnArray_maze_path_Diagonal(steps + "H", row, col - 1));
        }
        if (row > 1 && col > 1) {
            ans.addAll(returnArray_maze_path_Diagonal(steps + "D", row - 1, col - 1));
        }
        return ans;
    }

    static ArrayList<String> returnArray_maze_path(String steps, int row, int col) {
        if (row == 1 && col == 1) {
            ArrayList<String> path = new ArrayList<>();
            path.add(steps);
            return path;
        }
        ArrayList<String> ans = new ArrayList<>();
        if (row > 1) {
            ans.addAll(returnArray_maze_path(steps + "D", row - 1, col));
        }
        if (col > 1) {
            ans.addAll(returnArray_maze_path(steps + "R", row, col - 1));
        }
        return ans;
    }

    static void return_maze_path(String steps, int row, int col) {
        if (row == 1 && col == 1) {
            System.out.println(steps);
            return;
        }
        if (col > 1) {
            return_maze_path(steps + "R", row, col - 1);
        }
        if (row > 1) {
            return_maze_path(steps + "D", row - 1, col);
        }
    }

    static int count_maze_path(int row, int col) {
        if (row == 1 || col == 1) {
            return 1;
        }
        int left = count_maze_path(row - 1, col);
        int right = count_maze_path(row, col - 1);
        return left + right;
    }
}
