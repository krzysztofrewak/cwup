package lab09.Exceptions;

public class WriteCalledException extends InputException {
  public WriteCalledException(String input) {
    super(":w character has been provided. Application ends with: :x".replace(":x", input));
  }

	@Override
	public boolean shouldBreak() {
		return true;
	}
}
