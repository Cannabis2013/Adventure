package GameEngine.InitializeMap.Weapons;

import GameEngine.InitializeMap.LivingObjects.FatalBlowException;
import GameEngine.InitializeMap.LivingObjects.Organism;
import GameEngine.MapObjects.MapObject;

public class Mag7 extends RangeWeapon{
    public Mag7(int ammo) {
        super("shotgun", "Mag 7", ammo);
        _damage = 10;
    }

    @Override
    public String attack(MapObject targetObject) throws FatalBlowException {
        if(targetObject instanceof Organism){
            var target = (Organism) targetObject;
            target.takeHealth(_damage);
        }
        return null;
    }
}
