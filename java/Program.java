import Enums.Names;
import Units.*;
import Units.Monk;
import Units.Peasant;

import java.util.ArrayList;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        ArrayList<Unit> firstTeam = new ArrayList<>();
        randomizeTeam(5, firstTeam);
        ArrayList<Unit> secondTeam = new ArrayList<>();
        randomizeTeam(5, secondTeam);

        System.out.println("<-----First Team----->");
        firstTeam.forEach(unit-> System.out.println(unit.showStats()));
        System.out.println("<-----Second Team----->");
        secondTeam.forEach(unit-> System.out.println(unit.showStats()));
        System.out.println("<-------Move------->");
        firstTeam.forEach(Unit::turnMove);
        firstTeam.forEach(unit-> System.out.println(unit.showStats()));

        ArrayList<Unit> fight = new ArrayList<>();
        fight.addAll(firstTeam);
        fight.addAll(secondTeam);

        fight.sort(Unit::compareTo);
        System.out.println(fight);
    }
    private static void randomizeTeam(int teamSize, ArrayList<Unit> team){

        for (int i = 0; i < teamSize; i++){
            switch (new Random().nextInt(1, 8)) {
                case 1 -> team.add(new Sniper(team, getRandomName().toString()));
                case 2 -> team.add(new Mage(team, getRandomName().toString()));
                case 3 -> team.add(new PikeMan(team, getRandomName().toString()));
                case 4 -> team.add(new Peasant(team, getRandomName().toString()));
                case 5 -> team.add(new Monk(team, getRandomName().toString()));
                case 6 -> team.add(new XBowMan(team, getRandomName().toString()));
                case 7 -> team.add(new Bandit(team, getRandomName().toString()));
            }

        }
    }

    private static Names getRandomName() {
        Names[] values = Names.values();
        Random random = new Random();
        int index = random.nextInt(values.length);
        return values[index];
    }
}
