package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems;

import GameEngine.Contracts.IObjectEntity;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.LivingObjects.Human;

public abstract class Consumable extends Item {
    public Consumable(String shortTitle, String title) {
        super(shortTitle, title);
    }

    public abstract String consume(Human human);
}
