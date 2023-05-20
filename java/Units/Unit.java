package Units;

import Enums.Race;
import Enums.State;
import OtherClasses.Coordinates;
import Interfaces.IMovable;

import java.util.ArrayList;


public abstract class Unit implements IMovable, Comparable{
    protected int currentHealth;
    protected int maxHealth;
    protected int defenceSkill;
    protected int speed;
    protected String name;
    protected Race race;
    protected ArrayList<Unit> team;
    protected Coordinates position;
    protected State state;

    public Unit(int x, int y, ArrayList<Unit> team, int currentHealth, int defenceSkill, int speed, String name, Race race) {
        this.team = team;
        this.currentHealth = currentHealth;
        this.maxHealth = currentHealth;
        this.defenceSkill = defenceSkill;
        this.speed = speed;
        this.name = name;
        this.race = race;
        this.position = new Coordinates(x, y);
        this.state = State.Available;
//        if (new Random().nextBoolean()) this.currentHealth/=2;
    }

    public void step(ArrayList<Unit> enemyTeam){
//        System.out.printf("Move forward on %d steps\n", speed);
    }

    protected void getDamage(int hit){
        this.currentHealth -= hit;
        if (currentHealth <= 0) {
            this.state = State.Dead;
            currentHealth = 0;
        }
    }
    public int getCurrentHealth(){
        return this.currentHealth;
    }
    public Coordinates getCoords(){
        return new Coordinates(this.position.x, this.position.y);
    }
    public State getState(){
        return this.state;
    }
    public String getInfo(){
        return String.format ("%s %s %s \nStatus: %s\nHealth: %d\nSpeed: %d\nDefence: %d\n",
                this.getClass().getSimpleName(), this.race, this.name, this.state,
                this.currentHealth, this.speed, this.defenceSkill);
    }

    protected String getShortName(){
        return this.getClass().getSimpleName() + " " + name + ": ";
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+ " " + name + " " + this.state + " HP: " + this.currentHealth;
    }

    @Override
    public int compareTo(Object o) {
        Unit unit = (Unit)o;
        return unit.speed - this.speed;
    }
}
