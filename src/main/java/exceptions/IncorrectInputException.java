package exceptions;

public class IncorrectInputException extends RuntimeException {


    private static final String DEFAULT_MESSAGE = "Please provide correct inputs!";

    public IncorrectInputException() {
        super(DEFAULT_MESSAGE);
    }

}
