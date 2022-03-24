package GameEngine.InitializeMap.MapItems;

import GameEngine.MapObjects.MapObject;

public abstract class Consumable extends Item {
    public Consumable(String shortTitle, String title) {
        super(shortTitle, title);
    }

    public abstract String consume(MapObject object) throws InvalidObjectException;
}
