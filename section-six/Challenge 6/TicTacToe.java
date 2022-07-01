import java.util.Scanner;

public class TicTacToe {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
            System.out.println("\nLet's play tic tac toe");

            //Task 1: Create an array with three rows of '_' characters.
            char[][] gameBoard = {
              {'_', '_', '_'},
              {'_', '_', '_'},
              {'_', '_', '_'}
            };  
            //Task 2: Call the function printBoard();
            printBoard(gameBoard);

             
              /*
              {  Task 3: Loop through turns.

                  if (X) turn {
                     Task 4: call askUser(). 
                     Task 5: populate the board using askUser's return value.
                  } else {
                      Task 4: call askUser(). 
                      Task 5: populate the board using askUser's return value. Then, print it.

                  }

                Task 6 - Call the function.
                   if return value == 3 {
                     print: X wins and break the loop
                  } else if return value == -3 {
                     print: O wins and break the loop
                  }

              } 
              */
            char turn = 'x';
            System.out.println("It's " + turn + "'s turn");
            
            while (true) {
              if (turn == 'x') {
                int[] spot = askUser(gameBoard);
                gameBoard[spot[0]][spot[1]] = 'x';
                printBoard(gameBoard);
                turn = 'o';
              } else {
                int[] spot = askUser(gameBoard);
                gameBoard[spot[0]][spot[1]] = 'o';
                printBoard(gameBoard);
                turn = 'x';
              }

              int checkWin = checkWin(gameBoard);
              if (checkWin == 3) {
                System.out.println("X Wins!");
                break;
              } else if (checkWin == -3) {
                System.out.println("O Wins!");
              } else {
                System.out.println("It's " + turn + "'s turn");
              }
            }

            scan.close();
        }


    /** Task 2 - Write a function that prints the board.
     * Function name - printBoard()
     * @param board (char[][])
     * 
     * Inside the function:
     *   1. print a new line.
     *   2. print the board.
     *      • separate each row by two lines. 
     *      • each row precedes a tab of space
     *      • each character in the grid has one space from the other character
     */
    public static void printBoard(char[][] board) {
        System.out.println();
        for (int i = 0; i < board.length; i++) {
          System.out.print("\t");
          for (int j = 0; j < board[i].length; j++) {
            System.out.print(board[i][j] + " ");
          }
          System.out.print("\n\n");
        }
    }        

   /** Task 4 - Write a function that lets the user choose a spot
     * Function name – askUser
     * @param board (char[][] board)
     * @return spot (int[])
     * 
     * Inside the function
     *   1. Asks the user: - pick a row and column number: 
     *   2. Check if the spot is taken. If so, let the user choose again.
     *   3. Return the row and column in an int[] array.
     * 
     */
    public static int[] askUser(char[][] board) {
      while (true) {
        System.out.print("Pick a row: ");
        int row = scan.nextInt();
        System.out.print("Pick a column: ");
        int column = scan.nextInt();
        if (board[row][column] == '_') {
          int[] spot = {row, column};
          return spot;
        }
        System.out.println("That spot is taken. Please pick again");
      }
    }

    /** Task 6 - Write a function that determines the winner
     * Function name - checkWin 
     * @param board (char[][])
     * @return count (int)
     * 
     * Inside the function:
     *   1. Make a count variable that starts at 0.
     *   2. Check every row for a straight X or straight O (Task 7).
     *   3. Check every column for a straight X or straight O (Task 8).
     *   4. Check the left diagonal for a straight X or straight O (Task 9).
     *   5. Check the right diagonal for a straight X or straight O (Task 10).
     */
    public static int checkWin(char[][] board) {
      int count = 0;

      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          if (board[i][j] == 'x') {
            count++;
          } else if (board[i][j] == 'o') {
            count--;
          }
        }
        if (count == 3 || count == -3) {
          return count;
        } else {
          count = 0;
        }
      }

      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          if (board[j][i] == 'x') {
            count++;
          } else if (board[j][i] == 'o') {
            count--;
          }
        }
        if (count == 3 || count == -3) {
          return count;
        } else {
          count = 0;
        }
      }

      for (int i = 0; i < 3; i++) {
        if (board[i][i] == 'x') {
          count++;
        } else if (board[i][i] == 'o') {
          count--;
        }
      }

      if (count == 3 || count == -3) {
        return count;
      } else {
        count = 0;
      }

      for (int i = 0; i < 3; i++) {
        if (board[i][2 - i] == 'x') {
          count++;
        } else if (board[i][2 - i] == 'o') {
          count--;
        }
      }

      return count;
    }


}
