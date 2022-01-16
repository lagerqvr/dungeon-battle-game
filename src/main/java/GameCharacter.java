public class GameCharacter {

    private String playerName;
    private int health;

    public GameCharacter(String playerName, int health) {
        this.playerName = playerName;
        this.health = health;
    }

    public int takeDamage (int damage) {
        this.health -= damage;
        if (health < 0) {
            health = 0;
        }
        return health;
    }

    public String getName() {
        return (playerName);
    }

    public int getHealth() {
        return (health);
    }
}
