package matrix;
import java.util.Arrays;

public class FindWinnerOnATicTacToeGame
{
  public static String tictactoe(int[][] moves) {
    char[][] grid = new char[3][3];
    char ch;
    String res;
    for (int i = 0; i < moves.length; i++) {
        if (i % 2 == 0) {
            ch = 'X';
        } else {
            ch = 'O';
        }
        grid[moves[i][0]][moves[i][1]] = ch;
        if (i >= 4) {
            res = checkGame(grid, moves[i]);
            if (res.equals("Win")) {
                if (i % 2 == 0)
                    return "A";
                else 
                    return "B";
            }
        }
    }
    if (moves.length < 9)
        return "Pending";
    else
        return "Draw";
  }

  public static String checkGame(char[][] grid, int[] move) {
    char ch = grid[move[0]][move[1]];
    if (move[0] == 0 && move[1] == 0) {
        if ((grid[0][1] == ch && grid[0][2] == ch) || 
            (grid[1][0] == ch && grid[2][0] == ch) || 
            (grid[1][1] == ch && grid[2][2] == ch)) {
            return "Win";
        } else {
            return "Draw";
        }

    } else if (move[0] == 1 && move[1] == 0) {
        if ((grid[0][0] == ch && grid[0][2] == ch) || 
            (grid[1][1] == ch && grid[1][2] == ch)) {
            return "Win";
        } else {
            return "Draw";
        }

    } else if (move[0] == 2 && move[1] == 0) {
        if ((grid[0][0] == ch && grid[1][0] == ch) || 
            (grid[2][1] == ch && grid[2][2] == ch) || 
            (grid[1][1] == ch && grid[0][2] == ch)) {
            return "Win";
        } else {
            return "Draw";
        }
    } else if (move[0] == 0 && move[1] == 1) {
        if ((grid[0][0] == ch && grid[0][2] == ch) || 
            (grid[1][1] == ch && grid[2][1] == ch)) {
            return "Win";
        } else {
            return "Draw";
        }

    } else if (move[0] == 1 && move[1] == 1) {
        if ((grid[0][1] == ch && grid[2][1] == ch) || 
            (grid[1][0] == ch && grid[1][2] == ch) || 
            (grid[0][0] == ch && grid[2][2] == ch) ||
            (grid[0][2] == ch && grid[2][0] == ch)) {
            return "Win";
        } else {
            return "Draw";
        }

    } else if (move[0] == 2 && move[1] == 1) {
        if ((grid[0][1] == ch && grid[1][1] == ch) || 
            (grid[2][0] == ch && grid[2][2] == ch)) {
            return "Win";
        } else {
            return "Draw";
        }

    } else if (move[0] == 0 && move[1] == 2) {
        if ((grid[0][0] == ch && grid[0][1] == ch) || 
            (grid[1][2] == ch && grid[2][2] == ch) || 
            (grid[1][1] == ch && grid[2][0] == ch)) {
            return "Win";
        } else {
            return "Draw";
        }

    } else if (move[0] == 1 && move[1] == 2) {
        if ((grid[0][2] == ch && grid[2][2] == ch) || 
            (grid[1][0] == ch && grid[1][1] == ch)) {
            return "Win";
        } else {
            return "Draw";
        }

    } else if (move[0] == 2 && move[1] == 2) {
        if ((grid[0][2] == ch && grid[1][2] == ch) || 
            (grid[2][0] == ch && grid[2][1] == ch) || 
            (grid[0][0] == ch && grid[1][1] == ch)) {
            return "Win";
        } else {
            return "Draw";
        }
    }
    return "Draw";
  }

  public static String tictactoeOpt(int[][] moves) {
      int n = 3; // The grid is 3x3
      char[][] grid = new char[n][n];

      // Fill the grid with empty spaces initially
      for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
              grid[i][j] = ' ';
          }
      }

      // Place the moves on the grid
      for (int i = 0; i < moves.length; i++) {
          int row = moves[i][0];
          int col = moves[i][1];
          grid[row][col] = (i % 2 == 0) ? 'X' : 'O'; // Player A: 'X', Player B: 'O'
      }

      // Check rows, columns, and diagonals for a winner
      for (int i = 0; i < n; i++) {
          // Check row i
          if (grid[i][0] != ' ' && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
              return grid[i][0] == 'X' ? "A" : "B";
          }
          // Check column i
          if (grid[0][i] != ' ' && grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]) {
              return grid[0][i] == 'X' ? "A" : "B";
          }
      }

      // Check the main diagonal
      if (grid[0][0] != ' ' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
          return grid[0][0] == 'X' ? "A" : "B";
      }

      // Check the anti-diagonal
      if (grid[0][2] != ' ' && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
          return grid[0][2] == 'X' ? "A" : "B";
      }

      // Check if all the moves have been played
      if (moves.length == 9) {
          return "Draw";
      }

      // Otherwise, the game is still pending
      return "Pending";
  }
  public static void readme()
  {
    String str = "Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of Tic-Tac-Toe are:\n\n";

    str += "Players take turns placing characters into empty squares ' '.\n\n";

    str += "The first player A always places 'X' characters, while the second player B always places 'O' characters.\n\n";

    str += "'X' and 'O' characters are always placed into empty squares, never on filled ones.\n\n";

    str += "The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.\n\n";

    str += "The game also ends if all squares are non-empty.\n\n";

    str += "No more moves can be played if the game is over.\n\n";

    str += "Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that the ith move will be played on grid[rowi][coli]. return the winner of the game if it exists (A or B). In case the game ends in a draw return \"Draw\". If there are still movements to play return \"Pending\".\n\n";

    str += "You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty, and A will play first.\n";

    System.out.println(str);
  }

  public static void main()
  {
    AvailableCapturesForRook.readme();

    // Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
    // Output: "A"

    int[][] moves1 = {{0,0},{2,0},{1,1},{2,1},{2,2}};
    System.out.println("tictactoe(" + Arrays.deepToString(moves1) + ") = " +
                       tictactoe(moves1));
    // Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
    // Output: "B"
    int[][] moves2 = {{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}};
    System.out.println("tictactoe(" + Arrays.deepToString(moves2) + ") = " +
                       tictactoe(moves2));

    // Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
    // Output: "Draw"
    int[][] moves3 = {{0,0},{1,1},{2,0},{1,0},{1,2},{2,1},{0,1},{0,2},{2,2}};
    System.out.println("tictactoe(" + Arrays.deepToString(moves3) + ") = " +
                       tictactoe(moves3));

    System.out.println("tictactoeOpt(" + Arrays.deepToString(moves3) + ") = " +
                       tictactoeOpt(moves3));

  }
}