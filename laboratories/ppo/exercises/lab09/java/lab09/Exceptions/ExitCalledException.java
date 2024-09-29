package lab09.Exceptions;

public class ExitCalledException extends InputException {
  public ExitCalledException() {
    super(":q character has been provided. Application breaks.");
  }

	@Override
	public boolean shouldBreak() {
		return true;
	}
}
