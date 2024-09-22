import java.util.ArrayList;
import java.util.Random;

class Player {
  public String name;
  public int healthPoints = 100;

  public String identify() {
    return "[" + this.healthPoints + "] " + this.name;
  }
}

public class lab02 {
  public static void main(String[] args) {
    ArrayList < Player > players = new ArrayList < Player > ();

    Player player = new Player();
    player.name = getRandomName();
    players.add(player);

    for (Player p: players) {
      System.out.println(p.identify());
    }
  }

  protected static String getRandomName() {
    String[] names = {
      "John",
      "Jim",
      "Jack",
      "George",
      "Kevin"
    };

    return names[new Random().nextInt(names.length)];
  }
}
