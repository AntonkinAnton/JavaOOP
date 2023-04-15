import Units.*;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        Sniper sniper = new Sniper("Серега");
        Peasant peasant = new Peasant("Валера");

        System.out.printf("В бой вступают %s и %s\n\n", sniper, peasant);
        sniper.showStats();
        peasant.showStats();

        sniper.attack(peasant);
        peasant.showStats();
        sniper.attack(peasant);
        sniper.attack(peasant);
        sniper.attack(peasant);
        peasant.showStats();

        List<Unit> units = new ArrayList<>();
        units.add(new Bandit("Гарик"));
        units.add(new Monk("Кирилл"));
        units.add(new PikeMan("Бабиджон"));
        units.add(new Mage("Мэрлин"));
        units.add(new XBowMan("Орлинный Глаз"));

        System.out.println("За боем наблюдали:\n");

        for (Unit unit : units) {
            System.out.println(unit);
        }
    }
}
