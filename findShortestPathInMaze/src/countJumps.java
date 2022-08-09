import java.util.LinkedList;

public class countJumps {
  public static void main(String[] args) {
    int[][] inputArray = {
      {1, 0, 1, 1},
      {1, 1, 1, 1},
      {0, 0, 1, 0}
    };
    findMinJumps(inputArray);
  }

  private static void findMinJumps(int[][] inputArray) {
    int rows = inputArray.length, cols = inputArray[0].length, sx = -1, sy = -1;
    if ((rows == 0) && (cols == 0)) {
      System.out.println("No Path Found");
      return;
    }
    for (int i = 0; i < inputArray[0].length; i++) {
      if (inputArray[0][i] == 1) {
        sx = 0;
        sy = i;
        tryToFindPath(inputArray, sx, sy);
      }
    }
  }

  private static void tryToFindPath(int[][] inputArray, int sx, int sy) {
    Cell StartCell = new Cell(sx, sy);
    boolean isValidPath = false;
    String pathFound = "Path Found from (" + sx + ", " + sy + ")";
    StartCell.jumpCount = 0;
    Cell[][] board = new Cell[inputArray.length][inputArray[0].length];
    for (int i = 0; i < inputArray.length; i++) {
      for (int j = 0; j < inputArray[0].length; j++) {
        if (inputArray[i][j] != 0) board[i][j] = new Cell(i, j);
      }
    }

    LinkedList<Cell> Queue = new LinkedList<>();
    Queue.add(StartCell);
    Cell tempCell;
    while ((tempCell = Queue.poll()) != null) {
      if (tempCell.x == inputArray.length - 1) {
        isValidPath = true;
        break;
      }

      startMoving(board, Queue, tempCell.x + 1, tempCell.y, tempCell);
      startMoving(board, Queue, tempCell.x, tempCell.y + 1, tempCell);
    }

    if (isValidPath) System.out.println(pathFound + " JumpCounts = " + tempCell.jumpCount);
    else if (!isValidPath) System.out.println(pathFound + " and is not valid path");
  }

  private static void startMoving(
      Cell[][] board, LinkedList<Cell> queue, int x, int y, Cell parentCell) {
    if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] == null) return;
    int distance = parentCell.jumpCount + 1;
    Cell currentCell = board[x][y];
    if (distance < currentCell.jumpCount) {
      currentCell.jumpCount = distance;
      currentCell.nextCell = parentCell;
      queue.add(currentCell);
    }
  }

  public static class Cell {
    int x, y, jumpCount;
    Cell nextCell;

    public Cell(int x, int y) {
      this.x = x;
      this.y = y;
      this.jumpCount = Integer.MAX_VALUE;
      this.nextCell = null;
    }

    @Override
    public String toString() {
      return "(" + x + ", " + y + ")";
    }
  }
}
