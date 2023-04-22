package Units;

import Enums.Race;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Mage extends Wizard{
    public Mage(ArrayList<Unit> team, String name) {
        super(team, 40, 3,
                3,  name, Race.Human, 5,100, new int[]{9, 11});
    }

    public void turnMove(){

            int hpToAdd = new Random().nextInt(this.spellDamage[0],this.spellDamage[1]+1);
            if(this.mana < 1){
                System.out.println("Not enough mana\n");
                return;
            }
            int mostDamagedIndex = -1;
            int minHealth = 1;

            for (int i = 1; i < team.size(); i++) {
                if (team.get(i).currentHealth / team.get(i).maxHealth < minHealth &&
                        team.get(i).currentHealth != 0 &&
                        team.get(i) != this) {
                    minHealth = team.get(i).currentHealth / team.get(i).maxHealth;
                    mostDamagedIndex = i;
                }
            }
            if (mostDamagedIndex == -1){
                System.out.println("There's nobody to heal\n");
                return;
            }
            if (hpToAdd > this.mana) hpToAdd = this.mana;
            int manaBeforeUsage = this.mana;
            int pointsToHeal = team.get(mostDamagedIndex).maxHealth - team.get(mostDamagedIndex).currentHealth;
            if (pointsToHeal <= hpToAdd){
                team.get(mostDamagedIndex).currentHealth = team.get(mostDamagedIndex).maxHealth;
                this.mana -= pointsToHeal;
            }
            else{
                team.get(mostDamagedIndex).currentHealth += hpToAdd;
                this.mana -= hpToAdd;
            }
            System.out.println("Heal " + team.get(mostDamagedIndex).getClass().getSimpleName() +
                    " " + team.get(mostDamagedIndex).name + " by " + (manaBeforeUsage - this.mana) + " points\n");
    }

    public void multipleAttack(Unit... units){
        if (this.mana - 60 < 0) {
            System.out.println("Not enough mana!");
            return;
        }
        if (Arrays.asList(units).contains(this))
        {
            System.out.println("You can't hit yourself!\n");
            return;
        }
        if (Arrays.asList(units).contains(null) || Arrays.stream(units)
                .anyMatch(unit -> unit.currentHealth <= 0))
        {
            System.out.println("There's nobody to hit or one of your targets is dead\n");
            return;
        }
        int hit = (spellDamage[0] + spellDamage[1])/2;

        for (int i = 0; i < units.length; i++) {
            units[i].currentHealth -= hit;
        }
        System.out.printf("Make a magick multiple attack for %d unit with %d summary damage\n\n",
                units.length, ((spellDamage[0] + spellDamage[1])/2)* units.length);

        this.mana -= 60;
    }
}
