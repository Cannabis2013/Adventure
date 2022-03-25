package GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapRestrictions;

import GameEngine.MapGeneration.MapBuilders.Map.Door;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapItems.InvalidObjectException;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapItems.Usable;
import GameEngine.MapGeneration.MapBuilders.Map.MapObject;


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
    public String useOn(MapObject obj) throws InvalidObjectException {
        if(!(obj instanceof Door))
            throw new InvalidObjectException();
        var door = (Door) obj;
        door.unlock(ID);
        if(door.isLocked())
            return "Wrong key";
        return "Door open";
    }

    @Override
    public String presentate() {
        return _title;
    }
}
