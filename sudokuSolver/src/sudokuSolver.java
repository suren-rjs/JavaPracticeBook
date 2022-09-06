public class sudokuSolver {
    public static boolean solve(int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] == 0) {
                    for (int n = 1; n <= 9; n++) {
                        if (isSafe(i, j, n, sudoku)) {
                            sudoku[i][j] = n;
                            if (solve(sudoku)) return true;
                            else sudoku[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isSafe(int row, int col, int num, int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == num || sudoku[row][i] == num) return false;
            if (sudoku[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] sudoko = new int[][]{
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        solve(sudoko);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoko[i][j] + "  ");
            }
            System.out.println();
        }
    }
}