import java.util.LinkedList;

public class FindShortestPath {
  public static void main(String[] args) {
    int[][] maze = {
      {0, 0, 1},
      {0, 1, 1},
      {0, 0, 1}
    };

    int[] startingPoint = {0, 2};
    int[] endingPoint = {1, 1};

    toFindShortestPath(maze, startingPoint, endingPoint);
  }

  private static void toFindShortestPath(int[][] maze, int[] startingPoint, int[] endingPoint) {
    int sx = startingPoint[0], sy = startingPoint[1];
    int dx = endingPoint[0], dy = endingPoint[1];
    int rows = maze.length, columns = maze[0].length;

    if ((maze[sx][sy] == 0) || (maze[dx][dy] == 0)) {
      System.out.println("No Path Found!");
      return;
    }

    Cell[][] Board = new Cell[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (maze[i][j] != 0) Board[i][j] = new Cell(i, j);
      }
    }

    LinkedList<Cell> Queued = new LinkedList<>();
    Cell StartingNode = new Cell(sx, sy);
    StartingNode.distance = 0;
    Queued.add(StartingNode);
    Cell destinationNode = null;
    Cell tempCell;

    while ((tempCell = Queued.poll()) != null) {
      if ((tempCell.x == dx) && (tempCell.y == dy)) {
        destinationNode = tempCell;
        break;
      }
      // Up
      moveNode(Board, Queued, tempCell.x - 1, tempCell.y, tempCell);
      // Down
      moveNode(Board, Queued, tempCell.x + 1, tempCell.y, tempCell);
      // Left
      moveNode(Board, Queued, tempCell.x, tempCell.y - 1, tempCell);
      // Right
      moveNode(Board, Queued, tempCell.x, tempCell.y + 1, tempCell);
    }

    if (destinationNode == null) {
      System.out.println("There is No path!");
    } else {
      LinkedList<Cell> path = new LinkedList<>();
      do {
        path.addFirst(tempCell);
      } while ((tempCell = tempCell.parentCell) != null);
      System.out.println(path);
    }
  }

  private static void moveNode(
      Cell[][] board, LinkedList<Cell> queued, int x, int y, Cell parentNode) {
    if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] == null) return;
    int distance = parentNode.distance + 1;
    Cell currentNode = board[x][y];
    if (distance < currentNode.distance) {
      currentNode.distance = distance;
      currentNode.parentCell = parentNode;
      queued.add(currentNode);
    }
  }

  static class Cell {
    int x, y, distance;
    Cell parentCell;

    public Cell(int x, int y) {
      this.x = x;
      this.y = y;
      this.distance = Integer.MAX_VALUE;
      this.parentCell = null;
    }

    @Override
    public String toString() {
      return "(" + x + ", " + y + ")";
    }
  }
}
