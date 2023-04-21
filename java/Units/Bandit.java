package Units;

import Enums.Race;

public class Bandit extends FootWarrior{
    public Bandit(String name) {
        super(100, 100, 3, 6, name, Race.Orc, 5, new int[]{3, 6});
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
