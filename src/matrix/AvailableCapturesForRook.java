package matrix;
import java.util.Arrays;

public class AvailableCapturesForRook
{
  public static int numRookCaptures(char[][] board)
  {
    int count = 0;
    int indexR = 0;
    int indexC = 0;
    boolean found = false;
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[0].length; c++) {
        if (board[r][c] == 'R') {
          indexR = r;
          indexC = c;
          found = true;
          break; 
        }
      }
      if (found == true) {
          break;
      }
    }
    int r = indexR - 1;
    while (r >= 0) {
      if (board[r][indexC] == 'B') {
        break;
      } else if (board[r][indexC] == 'p') {
        count++;
        break;
      }
      r--;
    }
    r = indexR + 1;
    while (r < board.length) {
      if (board[r][indexC] == 'B') {
        break;
      } else if (board[r][indexC] == 'p') {
        count++;
        break;
      }
      r++;
    }

    int c = indexC - 1;
    while (c >= 0) {
      if (board[indexR][c] == 'B') {
        break;
      } else if (board[indexR][c] == 'p') {
        count++;
        break;
      }
      c--;
    }
    c = indexC + 1;
    while (c < board[0].length) {
      if (board[indexR][c] == 'B') {
        break;
      } else if (board[indexR][c] == 'p') {
        count++;
        break;
      }
      c++;
    }

    return count;
  }

  public static void readme()
  {
    String str = "You are given an 8 x 8 matrix representing a chessboard. There is exactly one white rook represented by 'R', some number of white bishops 'B', and some number of black pawns 'p'. Empty squares are represented by '.'.\n\n";

    str += "A rook can move any number of squares horizontally or vertically (up, down, left, right) until it reaches another piece or the edge of the board. A rook is attacking a pawn if it can move to the pawn's square in one move.\n\n";

    str += "Note: A rook cannot move through other pieces, such as bishops or pawns. This means a rook cannot attack a pawn if there is another piece blocking the path.\n\n";

    str += " Return the number of pawns the white rook is attacking.\n";

    System.out.println(str);
  }

  public static void main()
  {
    AvailableCapturesForRook.readme();

    // board = [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]] => 3
    char [][] board1 = {{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','R','.','.','.','p'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'}};

    System.out.println("numRookCaptures(" + Arrays.deepToString(board1) + ") = " +
                       numRookCaptures(board1));
    // board = [[".",".",".",".",".",".","."],[".","p","p","p","p","p",".","."],[".","p","p","B","p","p",".","."],[".","p","B","R","B","p",".","."],[".","p","p","B","p","p",".","."],[".","p","p","p","p","p",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]] => 0
    char [][] board2 = {{'.','.','.','.','.','.','.','.'},{'.','p','p','p','p','p','.','.'},{'.','p','p','B','p','p','.','p'},{'.','p','B','R','B','p','.','.'},{'.','p','p','B','p','p','.','.'},{'.','p','p','p','p','p','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'}};

    System.out.println("numRookCaptures(" + Arrays.deepToString(board2) + ") = " +
                       numRookCaptures(board2));

    // board = [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","p",".",".",".","."],["p","p",".","R",".","p","B","."],[".",".",".",".",".",".",".","."],[".",".",".","B",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."]] => 3
    char [][] board3 = {{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'p','p','.','R','.','p','B','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','B','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'}};

    System.out.println("numRookCaptures(" + Arrays.deepToString(board3) + ") = " +
                       numRookCaptures(board3));
  }

}