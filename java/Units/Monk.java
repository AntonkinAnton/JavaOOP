package Units;

import Enums.Race;

public class Monk extends NonWarriors {
    private int mana;
    public Monk(String name) {
        super(100, 100, 2, 3,
                name, Race.Human);
        this.mana = 50;
    }
    public void heal(Unit unit){
        if (unit == this) {
            System.out.println("You can't heal yourself!\n");
            return;
        }
        if (this.mana - 15 < 0) {
            System.out.println("Not enough mana!\n");
            return;
        }
        if (unit == null || unit.currentHealth <= 0){
            System.out.println("There's nobody to heal or he's dead\n");
            return;
        }
        if (unit.currentHealth == unit.maxHealth){
            System.out.println("He has maximum health\n");
            return;
        }
        System.out.println("Heal " + unit.race + " " + unit.name + " up to " + (unit.maxHealth * 0.20) + " points\n");
        if (unit.currentHealth + (unit.maxHealth * 0.20) >= unit.maxHealth) unit.currentHealth = unit.maxHealth;
        else unit.currentHealth += unit.maxHealth * 0.2;
        this.mana -= 15;
    }

    @Override
    public String showStats() {
        return super.showStats() + "Mana: " + this.mana + "\n";
    }
}
