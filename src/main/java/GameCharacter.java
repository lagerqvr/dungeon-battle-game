import java.util.Random;

abstract class GameCharacter {

    public String playerName;
    int health;

    String[] creatures = {"Werewolf", "Ghoul", "Dragon", "Witch"};

    Random random = new Random();

    public GameCharacter(String playerName, int health) {
        this.playerName = playerName;
        this.health = random.nextInt(health)+15;
    }

    protected GameCharacter() {
    }

    public int takeDamage (int damage) {
        this.health -= damage;
        if (health < 0) {
            health = 0;
        }
        return health;
    }

    public int setHealth(int health) {
        this.health = health;
        return health;
    }

    public int addHealth (int amount) {
        this.health += amount;
        return health;
    }

    public String getName() {
        return (playerName);
    }

    public int getHealth() {
        if (health < 0) {
            health = 0;
        }
        return (health);
    }

    public String getRandom() {
        String randomCreature = creatures[new Random().nextInt(creatures.length)];
        return randomCreature;
    }
}
