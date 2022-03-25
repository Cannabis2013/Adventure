package GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapEnemies;

import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.LivingObjects.Demon;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.LivingObjects.FatalBlowException;
import GameEngine.MapGeneration.MapBuilders.Map.MapObject;

public class Cyberdemon extends Demon {
    public Cyberdemon() {
        super("Cyberdemon");
    }

    @Override
    public String attack(MapObject object) {
        return null;
    }

    @Override
    public int takeHealth(int num) throws FatalBlowException {
        return 0;
    }
}
