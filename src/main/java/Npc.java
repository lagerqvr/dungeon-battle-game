import java.util.Random;

public class Npc extends GameCharacter {

    public Npc(String name, int health, double finesse, int damage) {
        this.playerName = name;
        this.health = random.nextInt(health)+23;
        this.finesse = finesse;
        this.damage = random.nextInt(damage)+5;
    }

    public static Npc createRandomNpc() {
        String[] creatures = {"Werewolf", "Ghoul", "Basilisk", "Witch", "Sandworm", "Skeleton", "Zombie"};
        Random random = new Random();
        return new Npc(creatures[random.nextInt(creatures.length)], 70,0.5, 16);
    }
}
