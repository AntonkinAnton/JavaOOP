package Units;

public class Sniper extends Shooter{

    public Sniper(String name) {
        super(100, 100, 3, new int[]{3, 5},
                3, 7, name, Race.Elf, new int[]{7, 9}, 10);
    }

    public void doubleShot(){
        System.out.println("Make double shot, but defence decrease to " + (this.defenceSkill*0.5) + " points");
    }
}
