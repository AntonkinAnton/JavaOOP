import Enums.Names;
import Units.*;
import Units.Monk;
import Units.Peasant;

import java.util.ArrayList;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        ArrayList<Unit> firstTeam = randomizeTeam(10);
        ArrayList<Unit> secondTeam = randomizeTeam(10);

        System.out.println("<-----First Team----->");
        firstTeam.forEach(unit-> System.out.println(unit.showStats()));
        System.out.println("<-----Second Team----->");
        secondTeam.forEach(unit-> System.out.println(unit.showStats()));

    }
    private static ArrayList<Unit> randomizeTeam(int teamSize){
        ArrayList<Unit> team = new ArrayList<>();

        for (int i = 0; i < teamSize; i++){
            switch (new Random().nextInt(1, 8)) {
                case 1 -> team.add(new Sniper(getRandomName().toString()));
                case 2 -> team.add(new Mage(getRandomName().toString()));
                case 3 -> team.add(new PikeMan(getRandomName().toString()));
                case 4 -> team.add(new Peasant(getRandomName().toString()));
                case 5 -> team.add(new Monk(getRandomName().toString()));
                case 6 -> team.add(new XBowMan(getRandomName().toString()));
                case 7 -> team.add(new Bandit(getRandomName().toString()));
            }

        }
        return team;
    }

    private static Names getRandomName() {
        Names[] values = Names.values();
        Random random = new Random();
        int index = random.nextInt(values.length);
        return values[index];
    }
}
