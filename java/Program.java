import Enums.Names;
import Enums.State;
import Units.*;
import Units.Monk;
import Units.Peasant;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Program {
        public static ArrayList<Unit> firstTeam = new ArrayList<>();
        public static ArrayList<Unit> secondTeam = new ArrayList<>();
        public static ArrayList<Unit> battle = new ArrayList<>();
    public static void main(String[] args) {
        randomizeTeam(10, firstTeam, 1);
        randomizeTeam(10, secondTeam, 10);
        battle.addAll(firstTeam);
        battle.addAll(secondTeam);
        battle.sort(Unit::compareTo);
        var scanner = new Scanner(System.in);
        boolean isBattleContinuing = true;
        while (isBattleContinuing){
            View.view();
            scanner.nextLine();
            for (Unit unit: battle) {
                if (firstTeam.contains(unit)) unit.turnMove(secondTeam);
                else unit.turnMove(firstTeam);
            }
            isBattleContinuing = false;
            for (Unit unit: firstTeam){
                if (unit.getState() == State.Dead) continue;
                isBattleContinuing = true;
                break;
            }
            if (!isBattleContinuing) {
                System.out.println("\n" + "Second team Win!");
                break;
            }
            isBattleContinuing = false;
            for (Unit unit: secondTeam){
                if (unit.getState() == State.Dead) continue;
                isBattleContinuing = true;
                break;
            }
            if (!isBattleContinuing) {
                System.out.println("\n" + "First team Win!");
                break;
            }

        }

//        System.out.println("<-----First Team----->");
//        firstTeam.forEach(unit-> System.out.println(unit.getInfo()));
//        System.out.println("<-----Second Team----->");
//        secondTeam.forEach(unit-> System.out.println(unit.getInfo()));
//        System.out.println("<-------Move------->");
//        firstTeam.forEach(unit -> unit.turnMove(secondTeam));
//        System.out.println("<-------First Team After Move------->");
//        firstTeam.forEach(unit-> System.out.println(unit.getInfo()));
//        System.out.println("<-------Second Team After Move------->");
//        secondTeam.forEach(unit-> System.out.println(unit.getInfo()));





//        System.out.println(battle);
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
