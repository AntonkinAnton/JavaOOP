package Units;

import Enums.Race;

import java.util.ArrayList;
import java.util.Random;

public class PikeMan extends FootWarrior{
    public PikeMan(ArrayList<Unit> team, String name) {
        super(team, 100, 5,7 , name, Race.Human, 6, new int[] {4, 6});
    }

    public void longHit(Unit unit){

        if (this.speed == 0){
            System.out.println("Your speed should be greater than zero\n");
            return;
        }
        System.out.println("Make a hit with 1,5x damage, but speed decrease by 1 point\n");

        if (unit == this){
            System.out.println("You can't hit yourself!\n");
            return;
        }
        if (unit == null || unit.currentHealth <= 0){
            System.out.println("There's nobody to hit or he's dead\n");
            return;
        }

        int hit = (new Random().nextInt((int)(damage[0]*1.5), (int)(damage[1]*1.5) + 1)) * ((attackSkill + 1)/(unit.defenceSkill + 1));
        System.out.printf("Hit " + unit.getClass().getSimpleName() + " " + unit.name + " with " + hit + " damage\n\n");
        unit.currentHealth -= hit;
        this.speed -= 1;

    }
}
