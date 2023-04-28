package Interfaces;
import Units.Unit;

import java.util.ArrayList;

public interface IMovable {
    String showStats();
    void turnMove(ArrayList<Unit> enemyTeam);
}
