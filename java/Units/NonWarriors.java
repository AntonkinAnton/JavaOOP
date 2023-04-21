package Units;

import Enums.Race;

public abstract class NonWarriors extends Unit{

    public NonWarriors(int currentHealth, int maxHealth, int defenceSkill, int speed, String name, Race race) {
        super(currentHealth, maxHealth, defenceSkill, speed, name, race);
    }
}
