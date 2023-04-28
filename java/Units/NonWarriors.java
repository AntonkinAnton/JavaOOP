package Units;

import Enums.Race;

import java.util.ArrayList;

public abstract class NonWarriors extends Unit{

    public NonWarriors(float x, float y, ArrayList<Unit> team, int currentHealth,
                       int defenceSkill, int speed, String name, Race race) {
        super(x, y, team, currentHealth, defenceSkill, speed, name, race);
    }
}
