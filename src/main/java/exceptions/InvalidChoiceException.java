package exceptions;

public class InvalidChoiceException extends ArrayIndexOutOfBoundsException{

    public InvalidChoiceException(String message) {
        super(message);
    }
}
