package Units;

import Enums.Race;
import Interfaces.IMagicAttack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

abstract class Wizard extends Warrior implements IMagicAttack {
    protected int mana;
    protected int[] spellDamage;

    public Wizard(float x, float y, ArrayList<Unit> team, int currentHealth, int defenceSkill,
                  int speed, String name, Race race, int attackSkill, int mana, int[] spellDamage) {
        super(x, y, team, currentHealth, defenceSkill, speed, name, race, attackSkill);
        this.mana = mana;
        this.spellDamage = spellDamage;
    }

    public void magicAttack(Unit unit){
        if (unit == this){
            System.out.println("You can't hit yourself!\n");
            return;
        }
        if (unit == null || unit.currentHealth <= 0){
            System.out.println("There's nobody to hit or he's dead\n");
            return;
        }
        if (this.mana == 0){
            System.out.println("You're out of mana\n");
            return;
        }

        int hit = (new Random().nextInt(spellDamage[0], spellDamage[1] + 1)) * ((attackSkill + 1)/(unit.defenceSkill + 1));
        System.out.printf("Spell attack " + unit.getClass().getSimpleName() + " " + unit.name + " with " + hit + " damage\n\n");
        unit.currentHealth -= hit;
        this.mana -= 5;
    }
    @Override
    public String showStats() {
        return super.showStats() + "Mana: " + this.mana + "\n" + "Magic Damage: " + Arrays.toString(spellDamage) + "\n";
    }

}
