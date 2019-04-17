package exceptions;

public class RiskException extends Exception {

    private static final String DEFAULT_MESSAGE = "Choose Risks!";

    public RiskException() {
        super(DEFAULT_MESSAGE);
    }

}
