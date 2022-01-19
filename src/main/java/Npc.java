import java.util.Random;

public class Npc extends GameCharacter {

    String[] creatures = {"Werewolf", "Ghoul", "Basilisk", "Witch", "Sandworm", "Skeleton", "Zombie"};

    Random random = new Random();

    String randomCreature = creatures[new Random().nextInt(creatures.length)];

    public Npc(int health, double finesse) {
        this.playerName = randomCreature;
        this.health = random.nextInt(health)+23;
        this.finesse = finesse;
    }
}
