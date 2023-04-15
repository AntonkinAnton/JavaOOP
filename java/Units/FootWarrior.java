package Units;

abstract class FootWarrior extends Unit{

    public FootWarrior(int currentHealth, int maxHealth, int attackSkill, int[] damage, int defenceSkill,
                       int speed, String name, Race race) {
        super(currentHealth, maxHealth, attackSkill, damage, defenceSkill, speed, name, race);
    }

}
