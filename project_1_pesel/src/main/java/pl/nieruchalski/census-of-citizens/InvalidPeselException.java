package pl.nieruchalski;

public class InvalidPeselException extends IllegalArgumentException {
    public InvalidPeselException() {
        super("Invalid PESEL number");
    }
}
