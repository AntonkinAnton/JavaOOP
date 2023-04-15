package Units;

import java.util.Random;

abstract class Unit {
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
        System.out.printf("Move forward on %d steps", speed);
    }
    public void hit(){
        System.out.printf("Make a melee hit with %d damage", new Random().nextInt(damage[0], damage[1] + 1));
    }
    public void defend(){
        System.out.printf("Take a defence pose. Reduce income hit on %d points", defenceSkill);
    }
    @Override
    public String toString() {
        return race + " " + name;
    }
}
