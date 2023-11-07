import java.util.*;

public class TicTacToe{

  static char[][] board = new char[3][3];
  private static int BOARDLEN = 3;
  static int x;
  static int y;

  public static void addToBoard(int x, int y, char xo){
    board[x][y] = xo;
  }

  public static void read(){
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the column:");
    x = scanner.nextInt();
    System.out.print("Enter the row:");
    y = scanner.nextInt();
    if (x > 3 || y > 3 || board[x-1][y-1] != 0){
      System.out.println("You must pick a number between 0-3 / must be valid spot");
      read();
    }
}

  public static char checkIfWon(){
    for (int i = 0; i < BOARDLEN; i++){
      if ((board[i][0] != 0) && (board[i][1] != 0) && (board[i][2] != 0) && (board[i][0] == board[i][1]) && (board[i][0]) == (board[i][2])) return board[i][0];
      if ((board[1][i] != 0) && (board[1][i] != 0) && (board[2][i] != 0) && (board[0][i] == board[1][i]) && (board[0][i]) == (board[2][i])) return board[0][i];
    }
    if ((board[0][0] != 0) && (board[1][1] != 0) && (board[2][2] != 0) && (board[0][0] == board[1][1]) && (board[0][0]) == (board[2][2])) return board[0][0];
    if ((board[0][2] != 0) && (board[1][1] != 0) && (board[2][0] != 0) && (board[0][2] == board[1][1]) && (board[0][2]) == (board[2][0])) return board[0][2];
    return 'n';
  }

  public static void drawBoard(){
    String print = "";
    for (int i = 0; i < BOARDLEN; i++){
      for (int j = 0; j < BOARDLEN; j++){
        if ((j == 0) || (j == 1)){
          if (board[i][j] == 0){
            print += "|- ";
          } else {
            print += "| " + board[i][j];
        }} else {
        if (board[i][j] == 0){
          print += "| - |\n";
        } else {
          print += "| " + board[i][j] + "|\n";
        }}
      }
    }
    System.out.println(print);
  }

  static int turn = 0;
  private static void changeTurn(){
    if (turn == 0) turn = 1;
    else turn = 0;
  }

  public static void playGame(){
    int run = 0;
    while(run == 0){

      drawBoard();
      char str = 'x';
      if (turn == 0){
        System.out.print("X's turn \n");
        str = 'x';}
      else {System.out.print("O's turn \n");
        str = 'o';}
      changeTurn();
      read();

      addToBoard(x-1, y-1, str);
      if (checkIfWon() == 'x'){
        System.out.println("X won!");
        run = 1;
        System.exit(0);
      }
      if (checkIfWon() == 'y'){
        System.out.println("Y won!");
        run = 1;
        System.exit(0);
      }
    }
  }
  public static void main(String[] args){
    while (true){
    playGame();
  }
  }
}
