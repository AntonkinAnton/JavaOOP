import Enums.Names;
import Enums.State;
import Units.*;
import Units.Monk;
import Units.Peasant;

import java.util.*;

public class Program {
    public static ArrayList<Unit> firstTeam = new ArrayList<>();
    public static ArrayList<Unit> secondTeam = new ArrayList<>();
    public static ArrayList<Unit> battle = new ArrayList<>();
    public static List<Names> namesList = new ArrayList<>(Arrays.asList(Names.values()));

    public static void main(String[] args) {

        randomizeTeam(10, firstTeam, 1);
        randomizeTeam(10, secondTeam, 10);
        battle.addAll(firstTeam);
        battle.addAll(secondTeam);
        battle.sort(Unit::compareTo);
        var scanner = new Scanner(System.in);


        while (true) {
            View.view();
            if (isAnyTeamWin()) break;
            scanner.nextLine();
            for (Unit unit : battle) {
                if (firstTeam.contains(unit)) unit.step(secondTeam);
                else unit.step(firstTeam);
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

    private static void randomizeTeam(int teamSize, ArrayList<Unit> team, int xSideOfTeam) {

        for (int i = 1; i <= teamSize; i++) {
            switch (new Random().nextInt(1, 8)) {
                case 1 -> team.add(new Sniper(team, getRandomName(), xSideOfTeam, i));
                case 2 -> team.add(new Mage(team, getRandomName(), xSideOfTeam, i));
                case 3 -> team.add(new PikeMan(team, getRandomName(), xSideOfTeam, i));
                case 4 -> team.add(new Peasant(team, getRandomName(), xSideOfTeam, i));
                case 5 -> team.add(new Monk(team, getRandomName(), xSideOfTeam, i));
                case 6 -> team.add(new XBowMan(team, getRandomName(), xSideOfTeam, i));
                case 7 -> team.add(new Bandit(team, getRandomName(), xSideOfTeam, i));
            }

        }
    }

    private static String getRandomName(){
        Random rnd = new Random();
        int rndIndex = rnd.nextInt(namesList.size());
        Names resultName = namesList.get(rndIndex);
        namesList.remove(rndIndex);
        return resultName.toString();
    }
    private static boolean isAnyTeamWin(){
        boolean isAnyoneWin = true;

        for (Unit unit : firstTeam) {
            if (unit.getState() != State.Dead) {
                isAnyoneWin = false;
                break;
            }
        }
        if (isAnyoneWin) {
            System.out.println("\n" + "Green team Win!");
            return isAnyoneWin;
        }
        isAnyoneWin = true;
        for (Unit unit : secondTeam) {
            if (unit.getState() != State.Dead) {
                isAnyoneWin = false;
                break;
            }
        }
        if (isAnyoneWin) {
            System.out.println("\n" + "Blue team Win!");
        }
        return isAnyoneWin;
    }
}