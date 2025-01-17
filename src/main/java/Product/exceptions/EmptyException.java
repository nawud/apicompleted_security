package Product.exceptions;

public class EmptyException extends RuntimeException {
    public EmptyException() { super("No data!"); }
}
