package Units;

import Enums.Race;

public class XBowMan extends Shooter {
    public XBowMan(String name) {
        super(100, 100, 3, 6, name, Race.Human,3,
                new int[]{5, 7}, 15);
    }
}
