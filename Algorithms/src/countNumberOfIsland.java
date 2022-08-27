public class countNumberOfIsland {
    static int[] moveX = {-1, -1, 0, 1, 1, 1, -1, 0}, moveY = {0, 1, 1, 1, 0, -1, -1, -1};

    static int Rows, Cols;

    public static void main(String[] args) {

        int[][] islandGrid = new int[][]{
                {1, 0, 1, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 1, 0, 1, 0, 1, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 1, 0, 0, 0},
                {1, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 1, 1, 1},
                {0, 1, 0, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 1, 1, 1, 0},
                {1, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 1, 1, 1}
        };
        Rows = islandGrid.length;
        Cols = islandGrid[0].length;
        System.out.println("No of Islands: " + countNumberOfIsland.numIslands(islandGrid));
    }

    public static int numIslands(int[][] islandGrid) {
        if (Rows == 0) return 0;
        int result = 0;

        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Cols; j++) {
                if (islandGrid[i][j] == 1) {
                    DFS(islandGrid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    public static void DFS(int[][] islandGrid, int row, int col) {
        if (row < 0 || col < 0 || row >= Rows || col >= Cols || islandGrid[row][col] != 1)
            return;
        islandGrid[row][col] = 0;
        for (int i = 0; i < 8; i++) {
            DFS(islandGrid, row + moveX[i], col + moveY[i]);
        }
    }
}