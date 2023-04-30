package Interfaces;
import Units.Unit;

import java.util.ArrayList;

public interface IMovable {
    String getInfo();
    void turnMove(ArrayList<Unit> enemyTeam);
}
