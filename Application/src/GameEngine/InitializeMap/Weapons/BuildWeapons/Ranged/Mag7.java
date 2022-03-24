package GameEngine.InitializeMap.Weapons.BuildWeapons.Ranged;

import GameEngine.InitializeMap.LivingObjects.FatalBlowException;
import GameEngine.InitializeMap.LivingObjects.Organism;
import GameEngine.MapObjects.MapObject;

public class Mag7 extends RangeWeapon{
    public Mag7() {
        super("shotgun", "Mag 7");
        _ammo = 7;
        _damage = 10;
    }

    @Override
    public String attack(MapObject targetObject) throws FatalBlowException {
        if(targetObject instanceof Organism){
            var target = (Organism) targetObject;
            useAmmo();
            target.takeHealth(_damage);
        }
        return null;
    }
}
