package lab09;

import java.util.Scanner;
import java.util.Set;
import lab09.Exceptions.EmptyStringException;
import lab09.Exceptions.ExitCalledException;
import lab09.Exceptions.ForbiddenCharacterException;
import lab09.Exceptions.MultipleCharactersException;
import lab09.Exceptions.WriteCalledException;

public class InputReader {
  protected String message = "";

  public void read() throws EmptyStringException, ExitCalledException, ForbiddenCharacterException, MultipleCharactersException, WriteCalledException {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Please type a letter: ");
    String input = scanner.nextLine();

    if (input.isEmpty()) {
      throw new EmptyStringException();
    }

    if (input.equals(":q")) {
      throw new ExitCalledException();
    }

    if (input.equals(":w")) {
      throw new WriteCalledException(message);
    }

    if (input.length() > 1) {
      throw new MultipleCharactersException();
    }

    Set<String> forbiddenCharacters = Set.of("ą", "ć", "ę", "ł", "ń", "ó", "ś", "ź", "ż");
    if (forbiddenCharacters.contains(input)) {
      throw new ForbiddenCharacterException(input);
    }

    message += input.toUpperCase();
  }
}
