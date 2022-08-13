import java.util.ArrayList;
import java.util.List;

public class GetAllPathsRecursionApproach {
  public static void main(String[] args) {
    int[][] mat = {{1, 2, 3}, {0, 10, 6}};
    List<Integer> path = new ArrayList<>();
    if (mat[0][0] == 0 || mat[mat.length - 1][mat[0].length - 1] == 0) {
      System.out.println("No Path Available");
      return;
    }
    findAllValidPaths(mat, 0, 0, path);
  }

  private static void findAllValidPaths(int[][] mat, int x, int y, List<Integer> path) {
    if (x > mat.length - 1 || y > mat[0].length - 1 || mat[x][y] == 0) return;
    path.add(mat[x][y]);
    if (x == mat.length - 1 && y == mat[0].length - 1) System.out.println(path);
    findAllValidPaths(mat, x + 1, y, path);
    findAllValidPaths(mat, x, y + 1, path);
    path.remove(path.size() - 1);
  }
}
