package GameEngine.InitializeMap.MapRestrictions;

import GameEngine.BuildMap.Rooms.Door;
import GameEngine.InitializeMap.MapItems.InvalidObjectException;
import GameEngine.InitializeMap.MapItems.Item;
import GameEngine.MapObjects.MapObject;

public class Key extends Item {
    private static int ID = 0;
    public Key(String title) {
        super("key", title);
        ID++;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String use(MapObject obj) throws InvalidObjectException {
        if(!(obj instanceof Door))
            throw new InvalidObjectException();
        var door = (Door) obj;
        door.unlock(ID);
        if(door.isLocked())
            return "Wrong key";
        return "";
    }
}
