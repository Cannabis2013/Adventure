package GameEngine.BuildMap.MapItems.Usables;

import GameEngine.BuildMap.MapItems.Item;
import GameEngine.BuildMap.Rooms.Door;

public class Key extends Item implements IUsable<Door>{
    private final int ID;
    public Key(String title, int id) {
        super("key", title);
        ID = id;
    }
    @Override
    public void use(Door target) {
    }
}
