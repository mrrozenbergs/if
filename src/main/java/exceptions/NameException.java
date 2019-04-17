package exceptions;

public class NameException extends Exception{

    private static final String DEFAULT_MESSAGE = "Wrong NAME";

    public NameException() {
        super(DEFAULT_MESSAGE);
    }
}
