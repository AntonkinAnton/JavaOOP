package Units;

import java.util.Random;

abstract class Wizard extends Unit{

    protected int mana;
    protected int[] spellDamage;

    public Wizard(int currentHealth, int maxHealth, int attackSkill, int[] damage, int defenceSkill,
                  int speed, String name, Race race, int mana, int[] spellDamage) {
        super(currentHealth, maxHealth, attackSkill, damage, defenceSkill, speed, name, race);
        this.mana = mana;
        this.spellDamage = spellDamage;
    }

    public void magicAttack(){
        System.out.printf("Make an spell attack with %d damage", new Random().nextInt(spellDamage[0], spellDamage[1] + 1));
    }

}
