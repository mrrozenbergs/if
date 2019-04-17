package exceptions;

public class RiskNotFoundException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "No risks were chosen!";

    public RiskNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

}
