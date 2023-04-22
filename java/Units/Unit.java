package Units;

import Enums.Race;
import Interfaces.IMovable;

import java.util.ArrayList;
import java.util.Random;


public abstract class Unit implements IMovable, Comparable{
    protected int currentHealth;
    protected int maxHealth;
    protected int defenceSkill;
    protected int speed;
    protected String name;
    protected Race race;
    protected ArrayList<Unit> team;

    public Unit(ArrayList<Unit> team, int currentHealth, int defenceSkill, int speed, String name, Race race) {
        this.team = team;
        this.currentHealth = currentHealth;
        this.maxHealth = currentHealth;
        this.defenceSkill = defenceSkill;
        this.speed = speed;
        this.name = name;
        this.race = race;
        if (new Random().nextBoolean()) this.currentHealth/=2;
    }

    public void turnMove(){
//        System.out.printf("Move forward on %d steps\n", speed);
    }

    public String showStats(){
        return String.format ("%s %s %s \nHealth: %d\nSpeed: %d\nDefence: %d\n",
                this.race, this.getClass().getSimpleName(), this.name, this.currentHealth, this.speed, this.defenceSkill);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + race + " " + name;
    }

    @Override
    public int compareTo(Object o) {
        Unit unit = (Unit)o;
        return unit.speed - this.speed;
    }
}
