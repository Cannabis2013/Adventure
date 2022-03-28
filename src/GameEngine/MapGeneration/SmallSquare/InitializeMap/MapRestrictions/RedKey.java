package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapRestrictions;

import GameEngine.Contracts.IObjectEntity;
import GameEngine.MapGeneration.SmallSquare.Models.Door;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.InvalidObjectException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Usable;


public class RedKey extends Usable {
    public RedKey(String title) {
        super("key", title, true);
    }

    @Override
    public String useOn(IObjectEntity obj) throws InvalidObjectException {
        if(!(obj instanceof Door))
            throw new InvalidObjectException();
        var door = (Door) obj;
        door.unlock(id());
        if(door.isLocked())
            return "Wrong key";
        return "Door open";
    }
}
