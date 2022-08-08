import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindPathBetweenTwoCellsInGivenMatrix {
  public static void main(String[] args) {
    int[][] maze = {
      {0, 3, 2},
      {3, 3, 0},
      {1, 3, 0}
    };

    findExistingPath(maze);
  }

  private static void findExistingPath(int[][] maze) {
    int rows = maze.length, columns = maze[0].length;
    int sx = Integer.MAX_VALUE,
        sy = Integer.MAX_VALUE,
        dx = Integer.MAX_VALUE,
        dy = Integer.MAX_VALUE;
    Cell[][] Board = new Cell[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (maze[i][j] != 0) {
          Board[i][j] = new Cell(i, j);
          if (maze[i][j] == 1) {
            sx = i;
            sy = j;
          } else if (maze[i][j] == 2) {
            dx = i;
            dy = j;
          }
        }
      }
    }
    List<Integer> startingAndEndingPoints = Arrays.asList(sx, sy, dx, dy);
    if ((maze[sx][sy] == 0)
        || (maze[dx][dy] == 0)
        || startingAndEndingPoints.contains(Integer.MAX_VALUE)) {
      System.out.println("There is no path Exists!");
      return;
    }

    LinkedList<Cell> queue = new LinkedList<>();
    Cell StartingPoint = new Cell(sx, sy);
    StartingPoint.distance = 0;
    queue.add(StartingPoint);
    Cell EndPoint = null;
    Cell tempCell;
    while ((tempCell = queue.poll()) != null) {
      if ((tempCell.x == dx) && (tempCell.y == dy)) {
        EndPoint = tempCell;
        break;
      }
      moveFromCurrentCell(Board, queue, tempCell.x - 1, tempCell.y, tempCell);
      moveFromCurrentCell(Board, queue, tempCell.x + 1, tempCell.y, tempCell);
      moveFromCurrentCell(Board, queue, tempCell.x, tempCell.y - 1, tempCell);
      moveFromCurrentCell(Board, queue, tempCell.x, tempCell.y + 1, tempCell);
    }

    if (EndPoint == null) {
      System.out.println("There is no path exists");
    } else {
      LinkedList<Cell> path = new LinkedList<>();
      do {
        path.addFirst(tempCell);
      } while ((tempCell = tempCell.parentNode) != null);
      System.out.println(true + "\n" + path);
    }
  }

  private static void moveFromCurrentCell(
      Cell[][] board, LinkedList<Cell> queue, int x, int y, Cell parentCell) {
    if (x < 0 || y < 0 || x >= board.length || board[x][y] == null || y >= board[0].length) return;
    int distance = parentCell.distance + 1;
    Cell currentCell = board[x][y];
    if (distance < currentCell.distance) {
      currentCell.distance = distance;
      currentCell.parentNode = parentCell;
      queue.add(currentCell);
    }
  }

  public static class Cell {
    int x, y, distance;
    Cell parentNode;

    public Cell(int x, int y) {
      this.x = x;
      this.y = y;
      this.distance = Integer.MAX_VALUE;
      this.parentNode = null;
    }

    @Override
    public String toString() {
      return "(" + x + ", " + y + ")";
    }
  }
}
