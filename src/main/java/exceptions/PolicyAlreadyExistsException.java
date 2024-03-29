package exceptions;

public class PolicyAlreadyExistsException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Policy already exists!";

    public PolicyAlreadyExistsException() {
        super(DEFAULT_MESSAGE);
    }
}
