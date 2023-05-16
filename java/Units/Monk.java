package Units;

import Enums.Race;
import Enums.State;

import java.util.ArrayList;

public class Monk extends NonWarriors {
    private int mana;
    public Monk(ArrayList<Unit> team, String name, int x, int y) {
        super(x, y, team, 30, 2, 2,
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
        if (unit.state != State.Dead){
            System.out.println("He's not dead\n");
            return;
        }

        System.out.println("Resurrect " + unit.race + " " + unit.name + ". His hp now " + unit.maxHealth + " points\n");
        unit.currentHealth = unit.maxHealth;
        unit.state = State.Available;
        this.mana -= 25;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "Mana: " + this.mana + "\n";
    }

    public String toString() {
        return super.toString() + " M: " + this.mana;
    }
}
