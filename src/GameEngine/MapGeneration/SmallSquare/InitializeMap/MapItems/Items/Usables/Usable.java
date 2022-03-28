package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Usables;

import GameEngine.Contracts.IObjectEntity;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.InvalidObjectException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Item;

public abstract class Usable extends Item {
    public Usable(String title, boolean reusable) {
        super(title);
        _reusable = reusable;
    }

    protected final boolean _reusable;

    public abstract String useOn(IObjectEntity obj) throws InvalidObjectException;
}
