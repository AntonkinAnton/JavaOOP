package Units;

import Enums.Race;
import Enums.State;
import Interfaces.IPhysicalAttack;
import OtherClasses.Coordinates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

abstract class FootWarrior extends Warrior implements IPhysicalAttack {

    protected int[] damage;

    public FootWarrior(int x, int y, ArrayList<Unit> team, int currentHealth,
                       int defenceSkill, int speed, String name, Race race, int attackSkill, int[] damage) {
        super(x, y, team, currentHealth, defenceSkill, speed, name, race, attackSkill);
        this.damage = damage;
    }

    @Override
    public void step(ArrayList<Unit> enemyTeam) {
        if (this.state == State.Dead)
        {
            return;
        }
        int nearestIndex = -1;
        int min = Integer.MAX_VALUE;
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
        if (min < 2){
            this.meleeAttack(enemyTeam.get(nearestIndex));
            return;
        }
        int xDistance = this.getCoords().x - enemyTeam.get(nearestIndex).getCoords().x;
        int yDistance = this.getCoords().y - enemyTeam.get(nearestIndex).getCoords().y;
        int xCopy = this.position.x;
        int yCopy = this.position.y;

        if (Math.abs(xDistance) > Math.abs(yDistance)){
            if (xDistance < 0) xCopy++;
            else xCopy--;
        } else {
            if (yDistance < 0) yCopy++;
            else yCopy--;
        }
        if (isCellFree(new Coordinates(xCopy, yCopy), this.team, enemyTeam)){
            this.position.x = xCopy;
            this.position.y = yCopy;
        }
    }

    public void meleeAttack(Unit unit){
        if (unit == this){
            System.out.println("You can't hit yourself!\n");
            return;
        }
        if (unit == null){
            System.out.println("There's nobody to hit\n");
            return;
        }
        int hit = (new Random().nextInt(damage[0], damage[1] + 1)) * (int)(Math.ceil((attackSkill + 1)/(float)(unit.defenceSkill + 1)));
        System.out.printf(getShortName() + "Hit " + unit.getClass().getSimpleName() + " " + unit.name + " with " + hit + " damage\n\n");
        unit.getDamage(hit);
    }


    public String getInfo(){
        return super.getInfo() +  String.format("Melee Damage: %s\n", Arrays.toString(damage));
    }




}
