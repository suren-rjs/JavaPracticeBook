import java.util.ArrayList;

class minCostPathRecursion {
  public static void main(String[] args) {
    int[][] cost = {
      {1, 1, 1, 1, 1},
      {0, 1, 0, 0, 0},
      {0, 1, 1, 1, 0},
      {0, 1, 0, 1, 1},
      {0, 1, 1, 1, 1}
    };

    System.out.println(
        "The minimum cost is " + findMinCostUsingRecursion(cost, cost.length, cost[0].length));
    findValueInMaze(cost, 0, 0, new ArrayList<>());
  }


  private static void findValueInMaze(int[][] cost, int x, int y, ArrayList<String> Path) {
    if (x < cost.length && y < cost[0].length && cost[x][y] != 0) {
      Path.add("(" + x + ", " + y + ") ");
      if (x == cost.length - 1 && y == cost[0].length - 1) {
        System.out.println(Path + "Total Jumps = " + (Path.size() - 1));
        System.exit(0);
      }
      findValueInMaze(cost, x + 1, y, Path);
      findValueInMaze(cost, x, y + 1, Path);
      Path.remove(Path.size() - 1);
    }
  }

  private static int findMinCostUsingRecursion(int[][] cost, int row, int col) {
    if (row == 0 || col == 0 || cost[row - 1][col - 1] == 0) return Integer.MAX_VALUE;
    if (row == 1 && col == 1) return cost[0][0];
    return Integer.min(
            findMinCostUsingRecursion(cost, row - 1, col),
            findMinCostUsingRecursion(cost, row, col - 1))
        + cost[row - 1][col - 1];
  }
}
