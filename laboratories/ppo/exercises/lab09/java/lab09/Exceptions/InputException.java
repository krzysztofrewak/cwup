package lab09.Exceptions;

abstract public class InputException extends Exception {
  public InputException(String message) {
    super(message);
  }

  public boolean shouldBreak() {
    return false;
  }
}
