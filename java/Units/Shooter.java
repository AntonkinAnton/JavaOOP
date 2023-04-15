package Units;

import java.util.Random;

abstract class Shooter extends Unit {
    protected int rangeDamage[];
    protected int ammunition;

    public Shooter(int currentHealth, int maxHealth, int attackSkill, int[] damage, int defenceSkill, int speed, String name, Race race, int[] rangeDamage, int ammunition) {
        super(currentHealth, maxHealth, attackSkill, damage, defenceSkill, speed, name, race);
        this.rangeDamage = rangeDamage;
        this.ammunition = ammunition;
    }

    public void shoot(){
        System.out.printf("Make a shot with %d damage", new Random().nextInt(rangeDamage[0], rangeDamage[1] + 1));
    }

    public void reload(){
        System.out.printf("Reload weapon. Ammo left: %d", ammunition);
    }
}
