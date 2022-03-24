package GameEngine.InitializeMap.MapRestrictions;

import GameEngine.BuildMap.Rooms.Door;
import GameEngine.InitializeMap.MapItems.InvalidObjectException;
import GameEngine.InitializeMap.MapItems.Usable;
import GameEngine.MapObjects.MapObject;


public class Key extends Usable {
    private static int ID = 0;
    public Key(String title) {
        super("key", title, true);
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
        return "Door open";
    }
}
