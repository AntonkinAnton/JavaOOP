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
// Монахи могут воскрешать павших за 30 маны. На клетке цели не должен стоять никакой живой юнит.
// Если маны нехватает или нет цели для воскрешения и мана не полная, то мана пополняется на 1 ед.
    @Override
    public void step(ArrayList<Unit> enemyTeam) {

        int bestTargetIndex = -1;
        int maxHpTarget = Integer.MIN_VALUE;
        for (int i = 0; i < this.team.size(); i++) {
            if (this.team.get(i).state == State.Dead && isCellFree(this.team.get(i).getCoords(),this.team,enemyTeam)) {
                int temp = this.team.get(i).maxHealth;
                if (maxHpTarget < temp) {
                    bestTargetIndex = i;
                    maxHpTarget = temp;
                }
            }
        }
        if (bestTargetIndex == -1){
            if (this.mana < 50) {
                System.out.println(getShortName() + "There's nobody to resurrect. Gain 1 mana point\n");
                this.mana += 1;
                return;
            } else {
                System.out.println(getShortName() + "There's nobody to resurrect. Mana is full\n");
                return;
            }
        }

       if (this.mana - 30 < 0) {
            System.out.println(getShortName() + "Not enough mana for resurrect. Gain 1 mana point\n");
            this.mana += 1;
            return;
        }
       resurrect(this.team.get(bestTargetIndex));
    }

    public void resurrect(Unit unit){
        if (unit == this) {
            System.out.println("You can't resurect yourself!\n");
            return;
        }

        System.out.println(getShortName() + "Resurrect " + unit.getClass().getSimpleName() + " " + unit.name + ". His hp now " + unit.maxHealth + " points\n");
        unit.currentHealth = unit.maxHealth;
        unit.state = State.Available;
        this.mana -= 30;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "Mana: " + this.mana + "\n";
    }

    public String toString() {
        return super.toString() + " M: " + this.mana;
    }
}
