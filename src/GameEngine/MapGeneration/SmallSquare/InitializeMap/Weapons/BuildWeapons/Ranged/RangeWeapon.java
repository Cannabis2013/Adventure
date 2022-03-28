package GameEngine.MapGeneration.SmallSquare.InitializeMap.Weapons.BuildWeapons.Ranged;

import GameEngine.Contracts.IInflictable;
import GameEngine.Contracts.IObjectEntity;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.LivingObjects.FatalBlowException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.InvalidObjectException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.Weapons.Weapon;

public abstract class RangeWeapon extends Weapon {
    protected int _ammo;
    protected int _rate = 1;
    private final String _soundLoaded;
    private final String _soundUnloaded;

    public RangeWeapon(String shortTitle, String title, String soundLoaded, String soundUnloaded) {
        super(shortTitle, title);
        _soundLoaded = soundLoaded;
        _soundUnloaded = soundUnloaded;
    }

    public int ammo() {return _ammo;}
    protected void useAmmo() {_ammo -= _rate;}

    private String shoot(){
        if(ammo() <= 0)
            return _soundUnloaded;
        useAmmo();
        return _soundLoaded;
    }

    private String shoot(IInflictable target) throws FatalBlowException {
        if(ammo() <= 0)
            return _soundUnloaded;
        useAmmo();
        target.inflict(_damage);
        return _soundLoaded;
    }

    @Override
    public String attack(IObjectEntity target) throws FatalBlowException, InvalidObjectException {
        if(target == null)
            return shoot();
        else if(!(target instanceof IInflictable))
            throw new InvalidObjectException();
        var inflictableTarget = (IInflictable) target;
        return shoot(inflictableTarget);
    }

    @Override
    public String presentate() {
        return String.format("%s (Damage: %s, Ammo: %s, Rate: %s)", _title, _damage, _ammo, _rate);
    }
}
