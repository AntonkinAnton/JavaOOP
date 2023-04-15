package Units;

public class Monk extends Wizard{
    public Monk(String name) {
        super(100, 100, 2, new int[]{2, 4}, 3, 5,
                name, Race.Human, 50, new int[]{7, 10});
    }

    public void heal(Unit unit){
        if (unit == this) {
            System.out.println("You can't heal yourself!");
            return;
        }
        System.out.println("Heal " + unit.race + " " + unit.name + " up to " + (unit.maxHealth * 0.15) + " points");
        if (unit.currentHealth + (unit.maxHealth * 0.15) > unit.maxHealth) unit.currentHealth = unit.maxHealth;
    }
}
