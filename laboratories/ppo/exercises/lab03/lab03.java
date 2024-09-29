import java.util.ArrayList;
import java.util.Random;

class Player {
  public String name;
  protected int healthPoints = 100;

  public int attack(Player player) {
    int hitPoints = (new Random().nextInt(3) + 1) * 10;
    player.takeHit(hitPoints);

    return hitPoints;
  }

  public void takeHit(int hitPoints) {
    this.healthPoints = this.healthPoints - hitPoints;
  }

  public boolean isDead() {
    return this.healthPoints <= 0;
  }
}

public class lab03 {
  public static void main(String[] args) {
    ArrayList < Player > players = new ArrayList < Player > ();

    Player luke = new Player();
    luke.name = "Luke Skywalker";
    players.add(luke);

    Player vader = new Player();
    vader.name = "Darth Vader";
    players.add(vader);

    int round = 1;
    boolean ongoing = true;

    while (ongoing) {
      Player attacker = getRandomPlayer(players);
      Player target = getRandomPlayer(players);
      int hitPoints = attacker.attack(target);

      System.out.println("Round " + round + ": " + attacker.name + " attacked " + target.name + " with " + hitPoints + " points.");

      for (Player p: players) {
        if (p.isDead()) {
          System.out.println("Player " + p.name + " died.");
          ongoing = false;
        }
      }

      round++;
    }
  }

  static Player getRandomPlayer(ArrayList < Player > players) {
    return players.get(new Random().nextInt(players.size()));
  }
}
