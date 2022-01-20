import java.util.Random;

public class Npc extends GameCharacter {

    public Npc(String name, int health, double finesse) {
        this.playerName = name;
        this.health = random.nextInt(health)+23;
        this.finesse = finesse;
    }
}
