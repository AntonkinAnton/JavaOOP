package Units;

public class Peasant extends FootWarrior{
    public Peasant(String name) {
        super(40, 40, 1, new int[]{1, 1}, 0, 3, name, Race.Human);
    }

    public void becameHumanShield(Unit unit){
        if (unit == this) return;
        System.out.println("Cover " + unit.race + " " + unit.name + " with your body");
    }
}
