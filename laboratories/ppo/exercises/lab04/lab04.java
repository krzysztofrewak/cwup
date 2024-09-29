import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

class Dice {
  public int roll() {
    return new Random().nextInt(6) + 1;
  }
}

class Player {
  public String name;

  public Player(String name) {
    this.name = name;
  }
}

class Game {
  public HashMap < Integer, Integer > fields = new HashMap < Integer, Integer > ();
  public ArrayList < Player > players = new ArrayList < Player > ();
  public Dice dice;

  public void prepareGame() {
    int index = 0;
    for (Player player: this.players) {
      this.fields.put(index, 0);
      index++;
    }
  }

  public void run() {
    Player winner = null;

    while (winner == null) {
      int index = 0;
      for (Player player: this.players) {
        int result = this.dice.roll();
        int position = this.fields.get(index) + result;
        this.fields.put(index, position);

        if (position >= 40) {
          position = 40;
        }

        System.out.println(player.name + " rolled " + result + ". Now is on position " + position);

        index++;

        if (position >= 40) {
          System.out.println(player.name + " won!");
          winner = player;
          break;
        }
      }
    }
  }
}

public class lab04 {
  public static void main(String[] args) {
    Game game = new Game();
    game.dice = new Dice();
    game.players = new ArrayList < Player > (
      Arrays.asList(
        new Player("Anakin Skywalker"),
        new Player("Obi-Wan Kenobi")
      )
    );

    game.prepareGame();
    game.run();
  }
}
