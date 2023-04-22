package Units;

import Enums.Race;
import Interfaces.IRangeAttack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

abstract class Shooter extends Warrior implements IRangeAttack {
    protected int[] rangeDamage;
    protected int ammunition;
    protected boolean isWeaponLoaded;

    public Shooter(ArrayList<Unit> team, int currentHealth, int defenceSkill, int speed, String name,
                   Race race, int attackSkill, int[] rangeDamage, int ammunition) {
        super(team, currentHealth, defenceSkill, speed, name, race, attackSkill);
        this.rangeDamage = rangeDamage;
        this.ammunition = ammunition;
        this.isWeaponLoaded = true;
    }


    public void reload(){
        if (this.ammunition == 0){
            System.out.println("You're out of ammo\n");
            return;
        }
        this.ammunition--;
        System.out.printf("Weapon reloaded. Ammo left: %d\n", this.ammunition);
    }

    @Override
    public void rangeAttack(Unit unit) {
        if (unit == this){
            System.out.println("You can't hit yourself!\n");
            return;
        }
        if (unit == null || unit.currentHealth <= 0){
            System.out.println("There's nobody to hit or he's dead\n");
            return;
        }
        if (!this.isWeaponLoaded){
            System.out.println("Your weapon is not loaded\n");
            return;
        }

        int hit = (new Random().nextInt(rangeDamage[0], rangeDamage[1] + 1)) * ((attackSkill + 1)/(unit.defenceSkill + 1));
        System.out.printf("Shot " + unit.getClass().getSimpleName() + " " + unit.name + " with " + hit + " damage\n\n");
        unit.currentHealth -= hit;
        isWeaponLoaded = false;
    }

    @Override
    public String showStats() {
        return super.showStats() + "Ammo: " + this.ammunition + "\n" + "Range Damage: " + Arrays.toString(rangeDamage) + "\n";
    }
}
