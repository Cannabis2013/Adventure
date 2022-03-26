package GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapRestrictions;

import GameEngine.MapGeneration.MapBuilders.Map.Door;
import GameEngine.MapGeneration.MapBuilders.Map.MapObject;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapItems.InvalidObjectException;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapItems.Usable;


public class Key extends Usable {
    public Key(String title) {
        super("key", title, true);
    }

    @Override
    public String useOn(MapObject obj) throws InvalidObjectException {
        if(!(obj instanceof Door))
            throw new InvalidObjectException();
        var door = (Door) obj;
        door.unlock(id());
        if(door.isLocked())
            return "Wrong key";
        return "Door open";
    }
}
