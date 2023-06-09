package Units;

import Enums.Race;
import Enums.State;

import java.util.ArrayList;


public class Peasant extends NonWarriors {
    public Peasant(ArrayList<Unit> team, String name, int x, int y) {
        super(x, y, team, 20, 1, 1, name, Race.Human);
    }

    @Override
    public void step(ArrayList<Unit> enemyTeam) {
        if (this.state == State.Busy) state = State.Available;
    }

    public void becameHumanShield(Unit unit){
        if (unit == this) {
            System.out.println("You can't cover yourself!");
            return;
        }
        if (unit == null || unit.currentHealth <= 0){
            System.out.println("There's nobody to cover or he's dead\n");
            return;
        }
        if (this.speed < 1 || this.currentHealth < 2){
            System.out.println("You can't do this");
            return;
        }
        System.out.println("Cover " + unit.race + " " + unit.name + " with your body. Increases " +
                unit.name + "health by " + (this.currentHealth - 1) + ", but your health = 1 and speed = 0\n\n");

        if (unit.currentHealth + (this.currentHealth-1) >= unit.maxHealth) unit.currentHealth = unit.maxHealth;
        else unit.currentHealth += (this.currentHealth-1);

        this.currentHealth -= (currentHealth-1);
        this.speed = 0;
    }
}
