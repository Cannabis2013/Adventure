package GameEngine.InitializeMap.MapItems;

import GameEngine.MapObjects.MapObject;

public abstract class Usable extends Item {
    public Usable(String typeDescription, String title, boolean reusable) {
        super(typeDescription, title);
        _reusable = reusable;
    }

    protected final boolean _reusable;

    public abstract String use(MapObject obj) throws InvalidObjectException;
}
