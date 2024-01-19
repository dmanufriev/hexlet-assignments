package exercise;

// BEGIN
public class NegativeRadiusException extends Exception {

    public NegativeRadiusException() {
        super("Radius is negative");
    }

    public NegativeRadiusException(String message) {
        super(message);
    }
}
// END
