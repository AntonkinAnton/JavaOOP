package Units;

public class Mage extends Wizard{
    public Mage(String name) {
        super(70, 70, 3, new int[]{3, 5},
                3, 5, name, Race.Human, 100, new int[]{9, 11});
    }

    public void splashAttack(){
        if (this.mana - 30 < 0) {
            System.out.println("Not enough mana!");
            return;
        }
        System.out.printf("Make an area magick attack with %d damage", spellDamage[1]);
        this.mana -= 30;
    }
}
