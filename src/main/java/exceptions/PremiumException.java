package exceptions;

public class PremiumException extends Exception {

    private static final String DEFAULT_MESSAGE = "Choose Risks!";

    public PremiumException() {
        super(DEFAULT_MESSAGE);
    }
}
