package GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapItems;

import GameEngine.MapGeneration.MapBuilders.Map.MapObject;

public abstract class Consumable extends Item {
    public Consumable(String shortTitle, String title) {
        super(shortTitle, title);
    }

    public abstract String consume(MapObject object) throws InvalidObjectException;
}
