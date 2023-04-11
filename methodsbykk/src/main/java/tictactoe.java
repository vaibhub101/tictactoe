import java.util.Scanner;

public class tictactoe {

    public static void main(String[] args) {

        char[][] gameBoard = new char[3][3];  //taking two values
        for (int row = 0; row < gameBoard.length; row++) {

            for (int col = 0; col < gameBoard[row].length; col++) {
                gameBoard[row][col] = ' ';
            }
        }

        char player = '0';
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);
        while (!gameOver) {
            // player should see the board to input the char
            printBoard(gameBoard);
            System.out.println("Player " + player + " enter: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (gameBoard[row][col] == ' ') {
                gameBoard[row][col] = player;
                gameOver = hasWon(gameBoard, player);
                if (gameOver) {
                    System.out.println("Player " + player + "has won : ");
                } else {
                    // if player ==x then player = O else player = X or we can write it as following
                    player = (player == 'X') ? '0' : 'X';
                }
            } else {
                System.out.println("invalid move");
            }
        }
    }


    public static boolean hasWon(char[][] gameBoard, char player) {
        for (int row = 0; row < gameBoard.length; row++) {
            if (gameBoard[row][0] == player && gameBoard[row][1] == player && gameBoard[row][2] == player) {
                return true;
            }
        }

        // check for columns
        for (int col = 0; col < gameBoard[0].length; col++) {
            if (gameBoard[0][col] == player && gameBoard[1][col] == player && gameBoard[2][col] == player) {
                return true;
            }
        }
        // diagonal
        if (gameBoard[0][0] == player && gameBoard[1][1] == player && gameBoard[2][2] == player) {
            return true;
        }

        if (gameBoard[0][2] == player && gameBoard[1][1] == player && gameBoard[2][0] == player) {
            return true;
        }

       return  false;
    }

    public  static  void printBoard(char [][] gameBoard) {
        for(int row = 0; row < gameBoard.length; row++){
            for (int col = 0; col < gameBoard.length; col++){
                System.out.print(gameBoard[row][col] + " | ");
            }
            System.out.println();
        }
    }
}
