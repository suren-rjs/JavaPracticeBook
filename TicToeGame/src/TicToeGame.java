import java.util.InputMismatchException;
import java.util.Scanner;

public class TicToeGame {
  static String[] board;
  static String Turn;

  public static void main(String[] args) {
    System.out.println(
        "------ Welcome TicToe ------\n0 -> quite game\n1- 9 keys are allowed for control\n");
    board = new String[9];
    Turn = "X";
    String winner = null;
    for (int i = 0; i < board.length; i++) {
      board[i] = String.valueOf(i + 1);
    }
    printBoard();
    System.out.println("---------- X's Turn : Select Slot : ");
    while (winner == null) {
      int userInput = getUsrInput();

      if (board[userInput - 1].equals(String.valueOf(userInput))) {
        board[userInput - 1] = Turn;
        Turn = Turn.equals("X") ? "O" : "X";
        printBoard();
        winner = checkWinner();
      } else {
        System.out.println("Slot already selected!");
      }
    }

    try {
      if (winner.equals("draw")) System.out.println("It's draw, Thank You!");
      else System.out.println(winner + " won the match!, Thank you!");

      System.out.println("Restarting ... ");
      main(args);
    } catch (NullPointerException e) {
      main(args);
    }
  }

  private static int getUsrInput() {
    Scanner Input = new Scanner(System.in);
    int userInput;
    try {
      userInput = Input.nextInt();
      if (userInput == 0) {
        System.out.println("Exiting...");
        System.exit(0);
      }
      if (!(userInput > 0 && 9 >= userInput)) {
        System.out.println("Invalid Slot Try again !");
        return getUsrInput();
      }
    } catch (InputMismatchException e) {
      System.out.println("Invalid Slot Try again !");
      return getUsrInput();
    }
    return userInput;
  }

  private static String checkWinner() {
    for (int i = 0; i < 8; i++) {
      String line = "";
      switch (i) {
        case 0:
          line = board[0] + board[1] + board[2];
          break;
        case 1:
          line = board[3] + board[4] + board[5];
          break;
        case 2:
          line = board[6] + board[7] + board[8];
          break;
        case 3:
          line = board[0] + board[3] + board[6];
          break;
        case 4:
          line = board[1] + board[4] + board[7];
          break;
        case 5:
          line = board[2] + board[5] + board[8];
          break;
        case 6:
          line = board[0] + board[4] + board[8];
          break;
        case 7:
          line = board[2] + board[4] + board[6];
          break;
      }
      if (line.equals("XXX")) return "X";
      if (line.equals("OOO")) return "O";
    }
    for (int i = 0; i < 9; i++) {
      if (board[i].equals(String.valueOf(i + 1))) {
        break;
      } else if (i == 8) {
        return "draw";
      }
    }
    System.out.println("---------- " + Turn + "'s Turn : Select Slot : ");
    return null;
  }

  private static void printBoard() {
    int count = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.print(board[count++] + " ");
      }
      System.out.print("\n");
    }
  }
}
