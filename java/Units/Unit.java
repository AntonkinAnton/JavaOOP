package Units;

import Enums.Race;
import Interfaces.IMovable;
import Interfaces.IStats;


public abstract class Unit implements IStats, IMovable {
    protected int currentHealth;
    protected int maxHealth;
    protected int defenceSkill;
    protected int speed;
    protected String name;
    protected Race race;

    public Unit(int currentHealth, int maxHealth, int defenceSkill, int speed, String name, Race race) {
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
        this.defenceSkill = defenceSkill;
        this.speed = speed;
        this.name = name;
        this.race = race;
    }

    public void move(){
        System.out.printf("Move forward on %d steps\n", speed);
    }

    public String showStats(){
        return String.format ("%s %s %s \nHealth: %d\nSpeed: %d\nDefence: %d\n",
                this.race, this.getClass().getSimpleName(), this.name, this.currentHealth, this.speed, this.defenceSkill);
    }

    @Override
    public String toString() {
        return race + " " + name;
    }
}
