package GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.LivingObjects;

import GameEngine.MapGeneration.MapBuilders.Map.MapObject;

public abstract class Demon extends Organism {
    public Demon(String title) {
        super(title);
    }

    public abstract String attack(MapObject object);
}
