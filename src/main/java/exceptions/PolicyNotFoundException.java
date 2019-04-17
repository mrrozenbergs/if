package exceptions;

public class PolicyNotFoundException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Policy not found..";

    public PolicyNotFoundException() {
        super(DEFAULT_MESSAGE);
    }
}
