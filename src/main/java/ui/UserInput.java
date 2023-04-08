package ui;

import exceptions.InvalidChoiceException;
import exceptions.InvalidPositionException;
import exceptions.InvalidSymbolException;

import java.util.List;
import java.util.Scanner;

public class UserInput {

    private static Scanner scanner = new Scanner(System.in);

    public int getPositionSelection(List<String> openSpaces) {
        System.out.println();
        System.out.println("Select an available position on the board: ");
        System.out.println("The available position(s) are " + String.join(", ", openSpaces));
        String playerPosition = scanner.nextLine(); // if this is string throws error down there

        while (!openSpaces.contains(playerPosition)) {

            int playerPositionToInt = Integer.parseInt(playerPosition); // Can't convert a string into integer
            try {
                if (playerPositionToInt > openSpaces.size() - 1 || playerPositionToInt < 0) {
                    throw new InvalidChoiceException("That choice is not part of the available positions.");
                } else if (!openSpaces.contains(playerPositionToInt)) {
                    throw new InvalidPositionException("That position already contains a symbol");
                }
            } catch (InvalidChoiceException e) {
                System.out.println(e.getMessage());
            } catch (InvalidPositionException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("That is not a valid choice.");
            } finally {
                System.out.println("Select an available position on the board: ");
                System.out.println("The available position(s) are " + String.join(", ", openSpaces));
                playerPosition = scanner.nextLine();
            }

        }


        return Integer.parseInt(playerPosition);
    }

    public char getPlayerSymbolChoice() {

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

        return playerChoice.charAt(0);
    }

}
