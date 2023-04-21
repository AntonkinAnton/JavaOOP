package Units;

import Enums.Race;

import java.util.Arrays;

public class Mage extends Wizard{
    public Mage(String name) {
        super(70, 70, 3,
                3,  name, Race.Human, 5,100, new int[]{9, 11});
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
