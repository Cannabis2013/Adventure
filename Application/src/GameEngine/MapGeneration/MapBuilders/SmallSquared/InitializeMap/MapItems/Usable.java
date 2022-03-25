package GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapItems;

import GameEngine.MapGeneration.MapBuilders.Map.MapObject;

public abstract class Usable extends Item {
    public Usable(String typeDescription, String title, boolean reusable) {
        super(typeDescription, title);
        _reusable = reusable;
    }

    protected final boolean _reusable;

    public abstract String useOn(MapObject obj) throws InvalidObjectException;
}
