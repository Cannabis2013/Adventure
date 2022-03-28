package GameEngine.MapGeneration.SmallSquare.InitializeMap.Weapons.BuildWeapons.Ranged;

import GameEngine.Contracts.IInflictable;
import GameEngine.Contracts.IObjectEntity;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.LivingObjects.FatalBlowException;

public class AK47 extends RangeWeapon{
    private final String _soundLoaded = "ratata";
    private final String _soundUnloaded = "click click click";
    public AK47() {
        super("Assault rifle", "AK47");
        _ammo = 30;
        _damage = 5;
        _rate = 3;
    }

    private String shoot(){
        useAmmo();
        return _soundLoaded;
    }

    private String shoot(IInflictable target) throws FatalBlowException {
        useAmmo();
        target.inflict(_damage);
        return _soundLoaded;
    }

    @Override
    public String attack(IObjectEntity target) throws FatalBlowException {
        if(ammo() <= 0)
            return _soundUnloaded;
        if(target == null)
            return shoot();
        else if(target instanceof IInflictable)
            return shoot((IInflictable) target);
        else
            return _soundLoaded;
    }
}
