package GameEngine.InitializeMap.Weapons.BuildWeapons.Ranged;

import GameEngine.InitializeMap.LivingObjects.FatalBlowException;
import GameEngine.InitializeMap.LivingObjects.Organism;
import GameEngine.MapObjects.MapObject;

public class AK47 extends RangeWeapon{

    public AK47() {
        super("Assault rifle", "AK47");
        _ammo = 30;
        _damage = 5;
        _rate = 3;
    }

    @Override
    public String attack(MapObject target) throws FatalBlowException {
        if(target instanceof Organism){
            var targetObject = (Organism) target;
            useAmmo();
            targetObject.takeHealth(_damage);
            return "ratatata";
        }
        return null;
    }
}
