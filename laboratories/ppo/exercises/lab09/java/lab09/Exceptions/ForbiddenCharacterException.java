package lab09.Exceptions;

public class ForbiddenCharacterException extends InputException {
  public ForbiddenCharacterException(String input) {
    super("Provided character :x is forbidden. Please continue.".replace(":x", input));
  }
}
