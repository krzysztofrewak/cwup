package lab09.Exceptions;

public class EmptyStringException extends InputException {
  public EmptyStringException() {
    super("Empty input has been provided. Please continue.");
  }
}
