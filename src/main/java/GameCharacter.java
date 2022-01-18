import java.util.Random;

abstract class GameCharacter {

    private String playerName;
    int health;

    Random random = new Random();

    public GameCharacter(String playerName, int health) {
        this.playerName = playerName;
        this.health = random.nextInt(health)+10;
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
}
