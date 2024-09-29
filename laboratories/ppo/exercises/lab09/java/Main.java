import lab09.Handler;
import lab09.InputReader;

public class Main {
	public static void main(String[] args) {
		boolean on = true;
		Handler handler = new Handler();
		InputReader reader = new InputReader();

		while (on) {
			try {
				reader.read();
			} catch (Throwable exception) {
				if (handler.handle(exception).shouldBreak()) {
					on = false;
				}
			}
		}
	}
}
