package Units;

import Enums.Race;
import Interfaces.IPhysicalAttack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

abstract class FootWarrior extends Warrior implements IPhysicalAttack {

    protected int[] damage;

    public FootWarrior(float x, float y, ArrayList<Unit> team, int currentHealth,
                       int defenceSkill, int speed, String name, Race race, int attackSkill, int[] damage) {
        super(x, y, team, currentHealth, defenceSkill, speed, name, race, attackSkill);
        this.damage = damage;
    }

    public void meleeAttack(Unit unit){
        if (unit == this){
            System.out.println("You can't hit yourself!\n");
            return;
        }
        if (unit == null || unit.currentHealth <= 0){
            System.out.println("There's nobody to hit or he's dead\n");
            return;
        }
        int hit = (new Random().nextInt(damage[0], damage[1] + 1)) * ((attackSkill + 1)/(unit.defenceSkill + 1));
        System.out.printf("Hit " + unit.getClass().getSimpleName() + " " + unit.name + " with " + hit + " damage\n\n");
        unit.getDamage(hit);
    }

    public String showStats(){
        return super.showStats() +  String.format("Melee Damage: %s\n", Arrays.toString(damage));
    }




}
