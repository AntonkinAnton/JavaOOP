import Enums.Names;
import Units.*;
import Units.Monk;
import Units.Peasant;

import java.util.ArrayList;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        ArrayList<Unit> firstTeam = new ArrayList<>();
        randomizeTeam(5, firstTeam, 1);
        ArrayList<Unit> secondTeam = new ArrayList<>();
        randomizeTeam(5, secondTeam, 10);

        System.out.println("<-----First Team----->");
        firstTeam.forEach(unit-> System.out.println(unit.showStats()));
        System.out.println("<-----Second Team----->");
        secondTeam.forEach(unit-> System.out.println(unit.showStats()));
        System.out.println("<-------Move------->");
        firstTeam.forEach(unit -> unit.turnMove(secondTeam));
        System.out.println("<-------First Team After Move------->");
        firstTeam.forEach(unit-> System.out.println(unit.showStats()));
        System.out.println("<-------Second Team After Move------->");
        secondTeam.forEach(unit-> System.out.println(unit.showStats()));

        ArrayList<Unit> battle = new ArrayList<>();
        battle.addAll(firstTeam);
        battle.addAll(secondTeam);

        battle.sort(Unit::compareTo);
        System.out.println(battle);
    }
    private static void randomizeTeam(int teamSize, ArrayList<Unit> team, int xSideOfTeam){

        for (int i = 1; i <= teamSize; i++){
            switch (new Random().nextInt(1, 8)) {
                case 1 -> team.add(new Sniper(team, getRandomName().toString(), xSideOfTeam, i));
                case 2 -> team.add(new Mage(team, getRandomName().toString(), xSideOfTeam, i));
                case 3 -> team.add(new PikeMan(team, getRandomName().toString(), xSideOfTeam, i));
                case 4 -> team.add(new Peasant(team, getRandomName().toString(), xSideOfTeam, i));
                case 5 -> team.add(new Monk(team, getRandomName().toString(), xSideOfTeam, i));
                case 6 -> team.add(new XBowMan(team, getRandomName().toString(), xSideOfTeam, i));
                case 7 -> team.add(new Bandit(team, getRandomName().toString(), xSideOfTeam, i));
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
