package lab09;

import lab09.Exceptions.InputException;

public class Handler {
  protected Throwable exception = null;

  public Handler handle(Throwable exception) {
    this.exception = exception;
    System.out.println(exception.getMessage());

    return this;
  }

  public boolean shouldBreak() {
    return switch(this.exception) {
      case InputException ex -> ex.shouldBreak();
      default -> false;
    };
  }
}
