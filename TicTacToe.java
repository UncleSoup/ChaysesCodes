import java.util.Scanner;

public class TicTacToe {

public static void main(String[] args) {
    char[][] board = new char[3][3]; // 3x3 game board
    initializeBoard(board); // fill board with '-' to start

    char currentPlayer = 'X'; // X always starts
    boolean gameEnded = false;

    Scanner scanner = new Scanner(System.in);

    while (!gameEnded) {
        printBoard(board);

        System.out.println("Player " + currentPlayer + ", enter your move (row and column 0-2): ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        // Check if the move is valid
        if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != '-') {
            System.out.println("Invalid move. Try again.");
        } else {
            board[row][col] = currentPlayer; // place the player's mark

            // Check if the player has won
            if (checkWin(board, currentPlayer)) {
                printBoard(board);
                System.out.println("Player " + currentPlayer + " wins!");
                gameEnded = true;
            } 
            // Check for tie
            else if (isBoardFull(board)) {
                printBoard(board);
                System.out.println("The game is a tie!");
                gameEnded = true;
            } 
            // Switch players
            else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }
    scanner.close();
}

// Method to initialize the board with dashes
public static void initializeBoard(char[][] board) {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            board[i][j] = '-';
        }
    }
}

// Method to print the current board
public static void printBoard(char[][] board) {
    System.out.println("Board:");
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            System.out.print(board[i][j] + " ");
        }
        System.out.println();
    }
}

// Method to check if a player has won
public static boolean checkWin(char[][] board, char player) {
    // Check rows
    for (int i = 0; i < 3; i++) {
        if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
            return true;
        }
    }

    // Check columns
    for (int j = 0; j < 3; j++) {
        if (board[0][j] == player && board[1][j] == player && board[2][j] == player) {
            return true;
        }
    }

    // Check diagonals
    if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
        return true;
    }

    if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
        return true;
    }

    return false;
}

// Method to check if the board is full (tie)
public static boolean isBoardFull(char[][] board) {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (board[i][j] == '-') {
                return false;
            }
        }
    }
    return true;
}

}


