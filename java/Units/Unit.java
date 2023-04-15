package Units;

import java.util.Random;

public abstract class Unit{
    protected int currentHealth;
    protected int maxHealth;
    protected int attackSkill;
    protected int[] damage;
    protected int defenceSkill;
    protected int speed;
    protected String name;
    protected Race race;

    protected enum Race{
        Human, Elf, Orc, Gnome
    }

    public Unit(int currentHealth, int maxHealth, int attackSkill, int[] damage, int defenceSkill, int speed, String name, Race race) {
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
        this.attackSkill = attackSkill;
        this.damage = damage;
        this.defenceSkill = defenceSkill;
        this.speed = speed;
        this.name = name;
        this.race = race;
    }

    public void move(){
        System.out.printf("Move forward on %d steps\n", speed);
    }

    public void attack(Unit unit){
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
        unit.currentHealth -= hit;


    }


    public void showStats(){
        System.out.printf("%s %s %s \nHealth: %d\nAttack: %d\nDefence: %d\n\n",
                this.race, this.getClass().getSimpleName(), this.name, this.currentHealth, this.attackSkill, this.defenceSkill );
    }

    @Override
    public String toString() {
        return race + " " + name;
    }
}
