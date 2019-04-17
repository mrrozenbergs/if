package exceptions;

public class NameNotFoundException extends RuntimeException{

    private static final String DEFAULT_MESSAGE = "Name not found";

    public NameNotFoundException() {
        super(DEFAULT_MESSAGE);
    }
}
