protected abstract class Unit {
    int currentHealth;
    int maxHealth;
    int damage;
    int speed;
    int defence;
    String name;
    Race race;

    enum Race{
        Human, Elf, Orc, Gnome
    }

}
