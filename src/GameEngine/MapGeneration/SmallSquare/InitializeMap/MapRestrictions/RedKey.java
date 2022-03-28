package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapRestrictions;

import GameEngine.Contracts.IObjectEntity;
import GameEngine.MapGeneration.SmallSquare.Map.Door;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.InvalidObjectException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Usables.Usable;


public class RedKey extends Usable {
    public RedKey(String title) {
        super(title, true);
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
