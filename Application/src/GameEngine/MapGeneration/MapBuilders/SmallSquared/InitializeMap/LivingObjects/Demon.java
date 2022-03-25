package GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.LivingObjects;

import GameEngine.MapGeneration.MapBuilders.Map.MapObject;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapItems.IPresentable;

public abstract class Demon extends Organism implements IPresentable {
    public abstract String attack(MapObject object);
}
