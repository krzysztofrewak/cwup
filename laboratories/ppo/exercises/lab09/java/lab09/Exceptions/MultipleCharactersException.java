package lab09.Exceptions;

public class MultipleCharactersException extends InputException {
  public MultipleCharactersException() {
    super("Providing more than one character is forbidden. Please continue.");
  }
}
