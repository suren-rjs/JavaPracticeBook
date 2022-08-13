import java.util.Arrays;
import java.util.List;

public class WordBreaking {
  public static void main(String[] args) {
    String str = "iloveicecreamandmango";

    List<String> dict =
        Arrays.asList(
            "mobile",
            "samsung",
            "sam",
            "sung",
            "man",
            "mango",
            "icecream",
            "and",
            "go",
            "i",
            "love",
            "ice",
            "cream");
    System.out.println("First Test:");

    wordBreakingUtil(str.length(), dict, str);
  }

  private static void wordBreakingUtil(int length, List<String> dict, String str) {
    String ans = "";
    FindAndAddBreaks(length, dict, str, ans);
  }

  private static void FindAndAddBreaks(int length, List<String> dict, String str, String ans) {
    for (int i = 1; i <= length; i++) {
      String word = str.substring(0, i);
      if (dict.contains(word)) {
        if (i == length) {
          System.out.println(ans + word);
          break;
        }
        FindAndAddBreaks(length - i, dict, str.substring(i, length), ans + word + " ");
      }
    }
  }
}
