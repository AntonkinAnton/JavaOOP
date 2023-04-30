package Units;

import Enums.Race;
import Enums.State;
import Interfaces.IRangeAttack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

abstract class Shooter extends Warrior implements IRangeAttack {
    protected int[] rangeDamage;
    protected int ammunition;

    public Shooter(int x, int y, ArrayList<Unit> team, int currentHealth, int defenceSkill,
                   int speed, String name, Race race, int attackSkill, int[] rangeDamage, int ammunition) {
        super(x, y, team, currentHealth, defenceSkill, speed, name, race, attackSkill);
        this.rangeDamage = rangeDamage;
        this.ammunition = ammunition;
    }

    @Override
    public void turnMove(ArrayList<Unit> enemyTeam) {
        if (this.ammunition <= 0){
            System.out.println(getShortName() + "Out of ammo!\n");
            return;
        }
        if (this.state == State.Dead)
        {
            return;
        }
        int nearestIndex = -1;
        float min = Float.MAX_VALUE;
        for (int i = 0; i < enemyTeam.size(); i++) {
            if (enemyTeam.get(i).state == State.Dead) continue;
            int temp = this.position.findDistance(enemyTeam.get(i).position);
            if (min > temp){
                nearestIndex = i;
                min = temp;
            }
        }
        if (nearestIndex == -1){
            System.out.println(getShortName() + "There's nobody to hit\n");
            return;
        }
        rangeAttack(enemyTeam.get(nearestIndex));

        for (int i = 0; i < this.team.size(); i++) {
            if (this.team.get(i) instanceof Peasant && this.team.get(i).state == State.Available){
                this.ammunition++;
                this.team.get(i).state = State.Busy;
                break;
            }
        }
    }

    @Override
    public void rangeAttack(Unit unit) {
        if (unit == this){
            System.out.println(getShortName() + "You can't hit yourself!\n");
            return;
        }
        if (unit == null){
            System.out.println(getShortName() + "There's nobody to hit\n");
            return;
        }

        int hit = (new Random().nextInt(rangeDamage[0], rangeDamage[1] + 1)) * ((attackSkill + 1)/(unit.defenceSkill + 1));
        System.out.printf(getShortName() + "Shot " + unit.getClass().getSimpleName() + " " + unit.name + " with " + hit + " damage\n\n");
        unit.getDamage(hit);
        this.ammunition--;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "Ammo: " + this.ammunition + "\n" + "Range Damage: " + Arrays.toString(rangeDamage) + "\n";
    }

    @Override
    public String toString() {
        return super.toString() + " Am: " + this.ammunition;
    }
}
