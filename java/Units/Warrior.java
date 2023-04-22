package Units;

import Enums.Race;

import java.util.ArrayList;

public abstract class Warrior extends Unit {

    protected int attackSkill;
    public Warrior(ArrayList<Unit> team, int currentHealth, int defenceSkill, int speed, String name, Race race, int attackSkill) {
        super(team, currentHealth, defenceSkill, speed, name, race);
        this.attackSkill = attackSkill;
    }
    public String showStats(){
    return super.showStats() +  String.format("Attack: %d\n", this.attackSkill);
    }
}
