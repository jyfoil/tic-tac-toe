package application;

import ui.UserInput;
import ui.UserOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static final int MAX_BOARD_POSITIONS = 9;
    public static final char X_MARKER = 'X';
    public static final char O_MARKER = 'O';

    /*
     * Winning positions for reference
     */ int[] winningPosition0 = {0, 1, 2};    // top horizontal
    int[] winningPosition1 = {3, 4, 5};    // middle horizontal
    int[] winningPosition2 = {6, 7, 8};    // bottom horizontal
    int[] winningPosition3 = {0, 3, 6};    // left vertical
    int[] winningPosition4 = {1, 4, 7};    // middle vertical
    int[] winningPosition5 = {2, 5, 8};    // right vertical
    int[] winningPosition6 = {0, 4, 8};    // top-left, bottom-right diagonal
    int[] winningPosition7 = {2, 4, 6};    // top-right, bottom-left diagonal

    UserOutput userOutput;
    UserInput userInput;
    private List<String> openSpaces;

    char[] board;

    public TicTacToe() {
        userInput = new UserInput();
        userOutput = new UserOutput();
        openSpaces = new ArrayList<>();
    }

    private char[] initializeBoard() {
        char[] board = new char[MAX_BOARD_POSITIONS];

        for (int i = 0; i < board.length; i++) {
            board[i] = Character.forDigit(i, 10);
        }

        return board;
    }

    private boolean hasAvailablePositions() {

        for (int i = 0; i < board.length; i++) {
            if (board[i] != X_MARKER && board[i] != O_MARKER) {
                return true;
            }
        }

        return false;
    }

    private List<String> availablePositions() {
        List<String> availablePositions = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            if (board[i] == X_MARKER || board[i] == O_MARKER) {
                continue;
            }

            availablePositions.add(String.valueOf(board[i]));
        }
        return availablePositions;
    }

    private void playerMark(int position, char playerChoice) {
        if (playerChoice == 'X') {
            if (board[position] != X_MARKER && board[position] != O_MARKER) {
                board[position] = X_MARKER;
            }
        } else if (playerChoice == 'O') {
            if (board[position] != X_MARKER && board[position] != O_MARKER) {
                board[position] = O_MARKER;
            }
        }
    }

    private void computerMark(int position, char computerChoice) {
        if (computerChoice == 'O') {
            if (board[position] != X_MARKER && board[position] != O_MARKER) {
                board[position] = O_MARKER;
            }
        } else if (computerChoice == 'X') {
            if (board[position] != X_MARKER && board[position] != O_MARKER) {
                board[position] = X_MARKER;
            }
        }
    }

    private boolean isWinningPosition(int[] position, char marker) {
        return board[position[0]] == marker && board[position[1]] == marker && board[position[2]] == marker;
    }

    private String decideWinner(char playerSymbol, char computerSymbol) {
        int[][] allWinningPositions = new int[][]{winningPosition0, winningPosition1, winningPosition2,
                winningPosition3, winningPosition4, winningPosition5, winningPosition6, winningPosition7};


        for (int[] eachWinningPositionArr : allWinningPositions) {
            if (isWinningPosition(eachWinningPositionArr, playerSymbol)) {
                return "Player";
            } else if (isWinningPosition(eachWinningPositionArr, computerSymbol)) {
                return "Computer";
            }
        }

        return "";
    }

    public void run() {
        this.board = initializeBoard();
        Scanner input = new Scanner(System.in);

        char playerSymbol = userInput.getPlayerSymbolChoice();
        char computerSymbol = (playerSymbol == 'X') ? 'O' : 'X';


        System.out.println();
        userOutput.gameIntroduction(playerSymbol);
        userOutput.displayBoard(board);


        while (hasAvailablePositions()) {

            openSpaces = availablePositions();

            int playerPosition = userInput.getPositionSelection(openSpaces);
            playerMark(playerPosition, playerSymbol);

            openSpaces = availablePositions();

            Random random = new Random();
            if (openSpaces.size() > 0) {
                int choice = random.nextInt(openSpaces.size());
                int computerPosition = Integer.parseInt(openSpaces.get(choice));
                computerMark(computerPosition, computerSymbol);
            }

            userOutput.displayBoard(board);


            boolean playerWin = decideWinner(playerSymbol, computerSymbol) == "Player";
            boolean computerWin = decideWinner(playerSymbol, computerSymbol) == "Computer";

            if (playerWin) {
                System.out.println("Congratulations you have won the game of Tic Tac Toe!");
                System.out.println("Thanks for playing!");
                return;
            } else if (computerWin) {
                System.out.println("The Computer has won the game of Tic Tac Toe!");
                System.out.println("Thanks for playing!");
                return;
            }


        }
    }
}

