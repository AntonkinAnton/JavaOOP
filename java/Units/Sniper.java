package Units;

import Enums.Race;

import java.util.Random;

public class Sniper extends Shooter{

    public Sniper(String name) {
        super(100, 100, 3,
                3, name, Race.Elf, 7, new int[]{5, 7}, 10);
    }

    public void doubleShot(Unit unit){

        if (this.defenceSkill == 0){
            System.out.println("Your defense should be greater than zero\n");
            return;
        }
        System.out.println("Make double shot. Damage increase twice for one shot but defence decrease by " + (this.defenceSkill/2) + " points\n");
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

        int hit = (new Random().nextInt(rangeDamage[0]*2, rangeDamage[1]*2 + 1)) * ((attackSkill + 1)/(unit.defenceSkill + 1));
        System.out.printf("Double shot in " + unit.getClass().getSimpleName() + " " + unit.name + " with " + hit + " damage\n\n");
        unit.currentHealth -= hit;
        this.defenceSkill -= (this.defenceSkill/2);
        isWeaponLoaded = false;
    }
}
