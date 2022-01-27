import java.util.Random;

public class Weapon {

    private String name;
    private int damage;

    Random random = new Random();

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = random.nextInt(damage)+8;
    }

    // Getter
    public String getName() {
        return name;
    }

    // Getter
    public int getDamage() {
        return damage;
    }

    // Setter
    public void setName(String newName) {
        this.name = newName;
    }

    public void setDamage(int newDamage) {
        this.damage = newDamage;
    }

    public static Weapon createRandomDrop() {
        String[] drops = {"dark wand", "sword of azeret", "dagger of emore", "wand of light", "scepter of pyresia", "cyresian stoneaxe", "bow of the badlands"};
        Random random = new Random();
        return new Weapon(drops[random.nextInt(drops.length)], random.nextInt(24)+8);
    }
}
