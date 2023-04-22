package Units;

import Enums.Race;

import java.util.ArrayList;

public class XBowMan extends Shooter {
    public XBowMan(ArrayList<Unit> team, String name) {
        super(team, 80, 3, 4, name, Race.Human,3,
                new int[]{5, 7}, 15);
    }
}
