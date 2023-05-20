package Interfaces;
import Enums.State;
import OtherClasses.Coordinates;
import Units.Unit;

import java.util.ArrayList;

public interface IMovable {
    String getInfo();
    void step(ArrayList<Unit> enemyTeam);
    default boolean isCellFree(Coordinates coord, ArrayList<Unit> alliedTeam, ArrayList<Unit> enemyTeam){
        for (Unit friendlyUnit: alliedTeam) {
            if (friendlyUnit.getCoords().equals(coord) && friendlyUnit.getState() != State.Dead) return false;
        }
        for (Unit enemyUnit: enemyTeam) {
            if (enemyUnit.getCoords().equals(coord) && enemyUnit.getState() != State.Dead) return false;
        }
        return true;
    }
}
