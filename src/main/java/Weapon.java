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
}
