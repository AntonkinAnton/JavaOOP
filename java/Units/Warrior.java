package Units;

import Enums.Race;

import java.util.ArrayList;

public abstract class Warrior extends Unit {

    protected int attackSkill;

    public Warrior(int x, int y, ArrayList<Unit> team, int currentHealth,
                   int defenceSkill, int speed, String name, Race race, int attackSkill) {
        super(x, y, team, currentHealth, defenceSkill, speed, name, race);
        this.attackSkill = attackSkill;
    }

    public String getInfo(){
    return super.getInfo() +  String.format("Attack: %d\n", this.attackSkill);
    }

    @Override
    public String toString() {
        return super.toString() + " A: " + this.attackSkill + " D: " + this.defenceSkill;
    }
}
