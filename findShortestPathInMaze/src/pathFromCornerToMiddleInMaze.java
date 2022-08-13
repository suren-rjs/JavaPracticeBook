public class pathFromCornerToMiddleInMaze {

  public static void main(String[] args) {

    int[][] maze = {
      {3, 5, 4, 4, 7, 3, 4, 6, 3},
      {6, 7, 5, 6, 6, 2, 6, 6, 2},
      {3, 3, 4, 3, 2, 5, 4, 7, 2},
      {6, 5, 5, 1, 2, 3, 6, 5, 6},
      {3, 3, 4, 3, 0, 1, 4, 3, 4},
      {3, 5, 4, 3, 2, 2, 3, 3, 5},
      {3, 5, 4, 3, 2, 6, 4, 4, 3},
      {3, 5, 1, 3, 7, 5, 3, 6, 4},
      {6, 2, 4, 3, 4, 5, 4, 5, 1}
    };

    printPathForGivenMaze(maze, 0, 0, "");
  }

  private static void printPathForGivenMaze(int[][] maze, int x, int y, String s) {
    if (x == maze.length / 2 && y == maze.length / 2) {
      s += "(" + x + ", " + y + ") -> Mid";
      System.out.println(s);
      return;
    }
    if (maze[x][y] == 0) return;
    int k = maze[x][y];
    maze[x][y] = 0;
    if (y + k < maze.length) printPathForGivenMaze(maze, x, y + k, s + "(" + x + ", " + y + ") ->");
    if (x + k < maze.length) printPathForGivenMaze(maze, x + k, y, s + "(" + x + ", " + y + ") ->");
    if (y - k > 0) printPathForGivenMaze(maze, x, y - k, s + "(" + x + ", " + y + ") ->");
    if (x - k > 0) printPathForGivenMaze(maze, x - k, y, s + "(" + x + ", " + y + ") ->");
    maze[x][y] = k;
  }
}
