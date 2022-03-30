package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.Ranged;

import GameEngine.Contracts.IInflictable;
import GameEngine.Contracts.IObjectEntity;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.FatalBlowException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.InvalidObjectException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.Weapon;

public abstract class RangeWeapon extends Weapon {
    protected int _ammo;
    protected int _rate = 1;

    public RangeWeapon(String title) {
        super(title);
    }

    public int ammo() {return _ammo;}
    protected void useAmmo() {_ammo -= _rate;}

    private int shoot(){
        if(ammo() <= 0)
            return 0;
        useAmmo();
        return 0;
    }

    private int shoot(IInflictable target) throws FatalBlowException {
        if(ammo() <= 0)
            return 0;
        useAmmo();
        target.inflict(_damage);
        return _damage;
    }

    @Override
    public int attack(){
        return shoot();
    }

    @Override
    public int attack(IObjectEntity target) throws FatalBlowException, InvalidObjectException {
        if(!(target instanceof IInflictable))
            throw new InvalidObjectException();
        var inflictableTarget = (IInflictable) target;
        return shoot(inflictableTarget);
    }

    @Override
    public String presentate() {
        return String.format("%s (Damage: %d, Ammo: %d, Rate: %d)", title(), _damage, _ammo, _rate);
    }
}
