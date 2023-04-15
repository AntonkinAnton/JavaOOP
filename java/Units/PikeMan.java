package Units;

public class PikeMan extends FootWarrior{
    public PikeMan(String name) {
        super(100, 100, 5,new int[] {4, 6}, 6, 7, name, Race.Human);
    }

    public void longHit(){
        if (this.speed == 0) {
            System.out.println("You can't do this!");
            return;
        }
        System.out.println("Make a hit with 1,5x damage, but speed decrease by 1 point");
        this.damage = new int[]{(int)(damage[0]* 1.5), (int)(damage[1] * 1.5)};
        this.speed -= 1;
    }
}
