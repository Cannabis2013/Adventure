package GameEngine.InitializeMap.MapEnemies;

import GameEngine.InitializeMap.LivingObjects.Demon;
import GameEngine.InitializeMap.LivingObjects.FatalBlowException;
import GameEngine.MapObjects.MapObject;

public class Cyberdemon extends Demon {
    @Override
    public String attack(MapObject object) {
        return null;
    }

    @Override
    public int takeHealth(int num) throws FatalBlowException {
        return 0;
    }
}
