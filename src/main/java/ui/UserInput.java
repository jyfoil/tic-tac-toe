package ui;

import exceptions.InvalidSymbolException;
import java.util.Scanner;

public class UserInput {

    private static Scanner scanner = new Scanner(System.in);

    public String getSelection() {

        return null;
    }

    public String getPlayerSymbolChoice() {

        System.out.print("Do you want to be X or O: ");
        String playerChoice = scanner.nextLine().toUpperCase();

        while (!playerChoice.equals("X") && !playerChoice.equals("O")) {
            try {
                throw new InvalidSymbolException("Invalid Symbol, enter X or O");
            } catch (InvalidSymbolException e) {
                System.out.println(e.getMessage());
                System.out.println();
                System.out.print("Do you want to be X or O: ");
                playerChoice = scanner.nextLine().toUpperCase();
            }
        }

        return playerChoice;
    }

}
