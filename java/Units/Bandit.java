package Units;

import Enums.Race;

import java.util.ArrayList;

public class Bandit extends FootWarrior{
    public Bandit(ArrayList<Unit> team, String name, int x, int y) {
        super(x, y, team, 70, 7, 6, name, Race.Orc, 5, new int[]{3, 7});
    }

    public void fastAttack(){
        if(this.attackSkill == 0){
            System.out.println("You can't do this");
            return;
        }
        System.out.println("Your speed increased by 2 points and attack skill decreased by 1 point");
        this.speed += 2;
        this.attackSkill -= 1;
    }
}
