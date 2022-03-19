package GameEngine.InitializeMap.MapRestrictions;

import GameEngine.InitializeMap.MapItems.Item;
import GameEngine.BuildMap.Rooms.Door;
import GameEngine.BuildMap.Rooms.WrongKeyException;

public class Key extends Item implements IKey<Door> {
    private static int ID = 0;
    public Key(String title) {
        super("key", title);
        ID++;
    }

    public int getID() {
        return ID;
    }

    @Override
    public void use(Door target) throws WrongKeyException {
        target.unlock(ID);
    }
}
