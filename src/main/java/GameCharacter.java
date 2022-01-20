import java.util.Random;

abstract class GameCharacter {

    public String playerName;
    double health;
    double damage;
    private String weapon = "knife";
    public double finesse;

    Random random = new Random();

    public GameCharacter(String playerName, int health) {
        this.playerName = playerName;
        this.health = health;
        this.weapon = weapon;
        this.damage = damage;
    }

    protected GameCharacter() {
    }

    public String createRandomNpc() {
        String[] creatures = {"Werewolf", "Ghoul", "Basilisk", "Witch", "Sandworm", "Skeleton", "Zombie"};
        Random random = new Random();
        String randomCreature = creatures[new Random().nextInt(creatures.length)];
        return randomCreature;
    }

    public double takeDamage (double damage) {
        this.health -= damage;
        if (health < 0) {
            health = 0;
        }
        return Math.round(health * 100.0) / 100.0;
    }

    public int setHealth(int health) {
        this.health = health;
        return health;
    }

    public double addHealth (int amount) {
        this.health += amount;
        return health;
    }

    public String getName() {
        return (playerName);
    }

    public String setName(String name) {
        this.playerName = name;
        return name;
    }

    public double getHealth() {
        if (health < 0) {
            health = 0;
        }
        return health;
    }

    public String setWeapon(String weapon) {
        this.weapon = weapon;
        return weapon;
    }

    public String getWeapon() {
        return weapon;
    }

    public double setDamage(double damage) {
        double temp = damage * finesse;
        this.damage = temp;
        return temp;
    }

    public double getDamage() {
        return Math.round(damage * 100.0) / 100.0;
    }
}
