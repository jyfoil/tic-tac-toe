package ui;

public class UserOutput {

    public void gameIntroduction(String playerChoice){
        String gameName = ConsoleColors.BLUE_BRIGHT + "Tic-" +
                ConsoleColors.GREEN_BRIGHT + "Tac-" +
                ConsoleColors.PURPLE_BRIGHT + "Toe" +
                ConsoleColors.RESET;
        System.out.println("*** Welcome to " + gameName + " ***");
        System.out.println("Get a line or diagonal of three " + playerChoice + " to win!");
    }

    public void displayBoard(char[] board){
//      System.out.println("  0  |  1  |  2 ");
//      System.out.println("-----+-----+-----");
//      System.out.println("  3  |  4  |  5 ");
//      System.out.println("-----+-----+-----");
//      System.out.println("  6  |  7  |  8 ");

        System.out.println("  " + board[0] + "  |  " + board[1] + "  |  " + board[2]);
        System.out.println("-----+-----+-----");
        System.out.println("  " + board[3] + "  |  " + board[4] + "  |  " + board[5]);
        System.out.println("-----+-----+-----");
        System.out.println("  " + board[6] + "  |  " + board[7] + "  |  " + board[8]);
    }
}
