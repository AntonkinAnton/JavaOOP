package Units;

import Enums.Race;

public abstract class Warrior extends Unit {

    protected int attackSkill;
    public Warrior(int currentHealth, int maxHealth, int defenceSkill, int speed, String name, Race race, int attackSkill) {
        super(currentHealth, maxHealth, defenceSkill, speed, name, race);
        this.attackSkill = attackSkill;
    }
    public String showStats(){
    return super.showStats() +  String.format("Attack: %d\n", this.attackSkill);
    }
}
