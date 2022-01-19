import java.util.Random;

public class Player extends GameCharacter {

    Random random = new Random();

    public Player(String playerName, int health, double finesse) {
        this.playerName = playerName;
        this.health = random.nextInt(health)+40;
        this.finesse = finesse;
    }
}
