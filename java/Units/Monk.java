package Units;

import Enums.Race;

import java.util.ArrayList;

public class Monk extends NonWarriors {
    private int mana;
    public Monk(ArrayList<Unit> team, String name) {
        super(team, 30, 2, 2,
                name, Race.Human);
        this.mana = 50;
    }
    public void resurrect(Unit unit){
        if (unit == this) {
            System.out.println("You can't resurect yourself!\n");
            return;
        }
        if (this.mana - 25 < 0) {
            System.out.println("Not enough mana!\n");
            return;
        }
        if (unit.currentHealth > 0){
            System.out.println("He's not dead\n");
            return;
        }

        System.out.println("Resurrect " + unit.race + " " + unit.name + ". He's hp now " + unit.maxHealth + " points\n");
        unit.currentHealth = unit.maxHealth;
        this.mana -= 25;
    }

    @Override
    public String showStats() {
        return super.showStats() + "Mana: " + this.mana + "\n";
    }
}
