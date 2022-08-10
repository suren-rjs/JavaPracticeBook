import java.util.Comparator;
import java.util.PriorityQueue;

class FindLowCostPath {

  public static void main(String[] args) {
    int[][] maze = {
      {31, 100, 65, 12, 18},
      {10, 13, 47, 157, 6},
      {100, 113, 174, 11, 33},
      {88, 124, 41, 20, 140},
      {99, 32, 111, 41, 20}
    };

    findShortCostPath(maze);
  }

  private static void findShortCostPath(int[][] maze) {
    int X = maze.length, Y = maze[0].length;
    int[] mx = {-1, 0, 1, 0}, my = {0, 1, 0, -1};
    int[][] costPathArray = new int[X][Y];
    for (int i = 0; i < X; i++) {
      for (int j = 0; j < Y; j++) {
        costPathArray[i][j] = Integer.MAX_VALUE;
      }
    }

    costPathArray[0][0] = maze[0][0];
    PriorityQueue<Cell> pq = new PriorityQueue<>(X * Y, Comparator.comparing(a -> a.distance));

    Cell tempCell;
    pq.add(new Cell(0, 0, maze[0][0]));

    while ((tempCell = pq.poll()) != null) {
      for (int i = 0; i < 4; i++) {
        int tempXMove = tempCell.x + mx[i];
        int tempYMove = tempCell.y + my[i];
        if (tempXMove > -1 && tempYMove > -1 && tempXMove < X && tempYMove < Y) {
          int tempMovedValue = maze[tempXMove][tempYMove];
          int updatedCurrentCell = costPathArray[tempCell.x][tempCell.y];
          int existCostCellValue = costPathArray[tempXMove][tempYMove];
          if (existCostCellValue > tempMovedValue + updatedCurrentCell) {
            if (costPathArray[tempXMove][tempYMove] != Integer.MAX_VALUE) {
              Cell existCell = new Cell(tempXMove, tempYMove, costPathArray[tempXMove][tempYMove]);
              pq.remove(existCell);
            }
            costPathArray[tempXMove][tempYMove] = tempMovedValue + updatedCurrentCell;
            pq.add(new Cell(tempXMove, tempYMove, costPathArray[tempXMove][tempYMove]));
          }
        }
      }
    }
    System.out.println(costPathArray[X - 1][Y - 1]);
  }

  static class Cell {
    int x, y, distance;

    public Cell(int x, int y, int distance) {
      this.x = x;
      this.y = y;
      this.distance = distance;
    }
  }
}
