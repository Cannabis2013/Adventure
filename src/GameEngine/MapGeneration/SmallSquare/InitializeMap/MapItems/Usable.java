package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems;

import GameEngine.Contracts.IObjectEntity;

public abstract class Usable extends Item {
    public Usable(String typeDescription, String title, boolean reusable) {
        super(typeDescription, title);
        _reusable = reusable;
    }

    protected final boolean _reusable;

    public abstract String useOn(IObjectEntity obj) throws InvalidObjectException;
}
