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

    private String shoot(){
        useAmmo();
        return "ratatata";
    }

    private String shoot(MapObject target) throws FatalBlowException {
        var targetObject = (Organism) target;
        useAmmo();
        targetObject.takeHealth(_damage);
        return "ratatata";
    }

    @Override
    public String attack(MapObject target) throws FatalBlowException {
        if(ammo() <= 0)
            return "Click click click";
        if(target == null)
            return shoot();
        else if(target instanceof Organism)
            return shoot(target);
        else
            return "ratatata";
    }
}
